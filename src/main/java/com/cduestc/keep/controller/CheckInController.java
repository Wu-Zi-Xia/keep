package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.CheckIn;
import com.cduestc.keep.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CheckInController {
    @Autowired
    CheckInService checkInService;
    @RequestMapping("checkIn")
    public void checkIn(HttpServletRequest request){
        checkInService.checkIn(request);
    }

@RequestMapping("getCheckIn")
public Object getCheckIn(@RequestParam("month") String month,HttpServletRequest request){
    List<CheckIn> checkIn = checkInService.getCheckIn(month, request);
    if(checkIn==null){
        return ResultDto.errorOf(500,"获取签到列表失败！！，（该用户可能为新用户）");
    }
    return ResultDto.oxOf(checkIn);

}



}
