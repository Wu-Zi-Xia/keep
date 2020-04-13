package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.mapper.ArmSportsMapper;
import com.cduestc.keep.model.*;
import com.cduestc.keep.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Slf4j
@Controller
public class SportsController {
    //A：大臂，F：小臂，C：胸部，B：背部，E：腹部，T：大腿，S：小腿
    @Autowired
    BellySportsService bellySportsService;
    @Autowired
    ArmSportsService armSportsService;
    @Autowired
    BackSportsServcie backSportsServcie;
    @Autowired
    ChestSportsService chestSportsService;
    @Autowired
    ForearmSportsService forearmSportsService;
    @Autowired
    ShankSportsService shankSportsService;
    @Autowired
    ThighSportsService thighSportsService;
    //获取腹部视频前十个
    @RequestMapping("getBellySports")
     public @ResponseBody Object getBellySports(){
        List<BellySports> bellySports = bellySportsService.getBellySports();
        return bellySports;
    }
    //获大臂视频前十个
    @RequestMapping("getArmSports")
    public @ResponseBody Object getArmSports(){
        List<ArmSports> sports = armSportsService.getSports();
        return ResultDto.oxOf(sports);
    }
    @RequestMapping("getBackSports")
    public @ResponseBody Object getBackSports(){
        List<BackSports> sports = backSportsServcie.getSports();
        return ResultDto.oxOf(sports);
    }
    //获取胸部视频前十个
    @RequestMapping("getChestSports")
    public @ResponseBody Object getChestSports(){
        List<ChestSports> sports = chestSportsService.getSports();
        return ResultDto.oxOf(sports);
    }
    //获取小臂视频前十个
    @RequestMapping("getForearmSports")
    public @ResponseBody Object getForearmSports(){
        List<ForearmSports> sports = forearmSportsService.getSports();
        return ResultDto.oxOf(sports);
    }
    //获取小腿视频前十个
    @RequestMapping("getShankSports")
    public @ResponseBody Object getShankSports(){
        List<ShankSports> sports = shankSportsService.getSports();
        return ResultDto.oxOf(sports);
    }
    //获取大腿视频前十个
    @RequestMapping("getThighSports")
    public @ResponseBody Object getThighSports(){
        List<ThighSports> sports = thighSportsService.getSports();
        return ResultDto.oxOf(sports);
    }
}
