package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchievePlanDto;
import com.cduestc.keep.dto.DeliverPlanDTO;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.dto.SportsDto;
import com.cduestc.keep.model.Plan;
import com.cduestc.keep.model.PlanProgress;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.interpreter.Interpreter;
import com.cduestc.keep.service.PlanService;
import com.cduestc.keep.service.RedisPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class PlanController {
    @Autowired
    PlanService planService;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisPlanService redisPlanService;

    //创建一个计划
    @RequestMapping("makePlan")
    public @ResponseBody Object makePlan(@RequestBody AchievePlanDto planDto, HttpServletRequest request, HttpServletResponse response){
        int insert = planService.createPlan(planDto, request,response);
        if(insert>0){
           return ResultDto.oxOf();
        }
        return ResultDto.errorOf(500,"创建计划失败！！");
    }

    //获取用户的计划
    @RequestMapping("getPlans")
    public @ResponseBody Object getPlans(HttpServletRequest request){

        List<DeliverPlanDTO> deliverPlanDTOS=new ArrayList<>();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String redisTableName="user:"+user.getUserId()+":plan:*";
        if(redisTemplate.keys(redisTableName).size()!=0){//redis中是否存在
            //存在就在redis中查询
            deliverPlanDTOS=redisPlanService.getPlan(redisTableName,user);
            System.out.println("redis");
            return ResultDto.oxOf(deliverPlanDTOS);
        }
        else{//redis中不存在，到mysql中查询，并且同步到redis中
            System.out.println("mysql");
            List<DeliverPlanDTO> allPlansByUserId = planService.getAllPlansByUserId(request);
            return ResultDto.oxOf(allPlansByUserId);
        }
    }

    //修改一个计划的当前状态
    @RequestMapping("updatePlan")
    public @ResponseBody void updatePlan(@RequestParam("planID") String planID,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        long l = Long.parseLong(planID);
        planService.updateState(l,user);
    }

}
