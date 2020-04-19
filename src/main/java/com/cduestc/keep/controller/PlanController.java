package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchievePlanDto;
import com.cduestc.keep.dto.DeliverPlanDTO;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.dto.SportsDto;
import com.cduestc.keep.model.Plan;
import com.cduestc.keep.model.PlanProgress;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.provider.interpreter.Interpreter;
import com.cduestc.keep.service.PlanProgressService;
import com.cduestc.keep.service.PlanService;
import com.cduestc.keep.service.RedisPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Slf4j
@Controller
public class PlanController {
    @Autowired
    PlanService planService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisPlanService redisPlanService;
    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @Value("${redis.keep.planTable}")
    String redisPlanTable;
    @Value("${redis.keep.planSort}")
    String redisPlanSort;
    @Value("${domin}")
    String domin;
    @Autowired
    PlanProgressService planProgressService;
    //创建一个计划
    @RequestMapping("makePlan")
    public @ResponseBody Object makePlan(@RequestBody AchievePlanDto planDto, HttpServletRequest request, HttpServletResponse response){
        String token = request.getHeader("token");
        User user = (User) request.getSession().getAttribute(sessionNamePre +token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        int insert = planService.createPlan(planDto, user,response);
        if(insert>0){
           return ResultDto.oxOf();
        }
        return ResultDto.errorOf(500,"创建计划失败！！");
    }

    //获取用户的计划
    @RequestMapping("getPlans")
    public @ResponseBody Object getPlans(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String token = request.getHeader("token");
        User user = (User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        //判断当前的整个计划是否已经结束了
        if(planProgressService.isEnd(user)){//结束了当前的计划,
            ResultDto resultDto=new ResultDto();
            List<String> urls=new ArrayList<>();
            urls.add(domin+"makePlan");
            urls.add(domin+"resetPlanState");
            resultDto.setCode(1010);
            resultDto.setMessage("当前计划已经结束，你可以有如下选择。");
            resultDto.setData(urls);
            return resultDto;
        }
        Long userId = user.getUserId();
        List<DeliverPlanDTO> deliverPlanDTOS;
        if(redisTemplate.hasKey(redisPlanSort+userId)){//redis中是否存在
            //存在就在redis中查询
            deliverPlanDTOS=redisPlanService.getPlan(userId);
            System.out.println("redis");
            return ResultDto.oxOf(deliverPlanDTOS);
        }
        else{//redis中不存在，到mysql中查询，并且同步到redis中
            System.out.println("mysql");
            List<DeliverPlanDTO> allPlansByUserId = planService.getAllPlansByUserId(user);
            if(allPlansByUserId==null){
                return ResultDto.errorOf(500,"还没有属于自己的计划！！！");
            }else{
            //放入到redis之后，进行重定向
            response.sendRedirect(domin+"getPlans");
            return null;
            }
        }
    }

    //修改一个计划的当前状态
    @RequestMapping("updatePlan")
    public @ResponseBody Object updatePlan(@RequestParam("planId") String planID,
                                         HttpServletRequest request,
                                         HttpServletResponse response) throws IOException {
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        long l = Long.parseLong(planID);
        if(redisTemplate.hasKey(redisPlanTable+planID)){//判断redis中是否有值
            planService.updateState(l,user);
        }
        else{//如果没有就去数据库里面拿并且放入到redis再重定向访问这个接口
            planService.getAllPlansByUserId(user);
            response.sendRedirect(domin+"updatePlan?planId="+planID);
            return ResultDto.oxOf();
        }
return null;
    }
    @RequestMapping("getPlan")
    public @ResponseBody Object getPlan(@RequestParam("planId") String planId,
                                        HttpServletRequest request,
                                        HttpServletResponse response) throws IOException {
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre +token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        long l = Long.parseLong(planId);
    if(redisTemplate.hasKey(redisPlanSort+user.getUserId())){//判断redis中是否存在表
        DeliverPlanDTO planById = redisPlanService.getPlanById(planId);
        if(planById==null){
            return ResultDto.errorOf(500,"计划不见了！！！");
        }
        else{
            return ResultDto.oxOf(planById);
        }
       }else{//同步到redis然后重定向
        planService.getAllPlansByUserId(user);
        response.sendRedirect(domin+"getPlan?planId="+planId);
        return null;
    }

    }

}
