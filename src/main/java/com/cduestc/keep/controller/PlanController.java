package com.cduestc.keep.controller;

import com.cduestc.keep.dto.PlanDto;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.dto.SportsDto;
import com.cduestc.keep.model.Plan;
import com.cduestc.keep.provider.interpreter.Interpreter;
import com.cduestc.keep.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("makePlan")
    public @ResponseBody Object makePlan(@RequestBody PlanDto planDto, HttpServletRequest request, HttpServletResponse response){
        int insert = planService.createPlan(planDto, request,response);
        if(insert>0){
            ResultDto.oxOf();
        }
        return ResultDto.errorOf(500,"创建计划失败！！");
    }
    @RequestMapping("getPlans")
    public @ResponseBody Object getPlans(HttpServletRequest request){
        List<Plan> allPlans = planService.getAllPlansByUserId(request);
        if(allPlans==null){
            return ResultDto.errorOf(500,"你还没有属于自己的计划！！");
        }
        List<SportsDto> sportsDtos=new ArrayList<>();
        Iterator<Plan> iterator = allPlans.iterator();
        while(iterator.hasNext()){
            SportsDto sportsUrl = Interpreter.getSportsUrl(iterator.next().getSports());
            sportsDtos.add(sportsUrl);
        }
        return ResultDto.oxOf(sportsDtos);
    }
}
