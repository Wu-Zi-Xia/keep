package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class FriendController {
    @Autowired
    FriendService friendService;
    @RequestMapping("addFriend")
    public Object AddFriend(@RequestParam(value="FriendNumber")String friendNumber,
                            HttpSession session){
        int i = friendService.addFriend(friendNumber, session);
if(i>0){
    return ResultDto.oxOf("添加好友成功！！");
}
        return ResultDto.errorOf(500,"添加好友失败！！");    }
}
