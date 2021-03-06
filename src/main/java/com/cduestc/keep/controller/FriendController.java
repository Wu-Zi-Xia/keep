package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.FriendService;
import com.cduestc.keep.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class FriendController {
    @Autowired
    FriendService friendService;
    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @Autowired
    UserService userService;
    @RequestMapping("makeFriends")
    public @ResponseBody Object AddFriend(@RequestParam(value="userId")Long userId, HttpServletRequest request){
        //判断用户是否存在
        if(userService.selectUserByID(userId)==null){
            return ResultDto.errorOf(1001,"用户不存在");
        }
        String token = request.getHeader("token");
        User user = (User) request.getSession().getAttribute(sessionNamePre +token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        int i = friendService.addFriend(userId, user);

        if(i>0){
               return ResultDto.oxOf("关注成功！！");
         }
        return ResultDto.errorOf(500,"关注失败！！");
    }
    //取消关注朋友的端口
    @RequestMapping("deleteFriend")
    public @ResponseBody Object deleteFriend(@RequestParam(value = "userId") String userId,
                                             HttpServletRequest request){
        String token = request.getHeader("token");
        User user = (User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        int i = friendService.deleteFriend(userId, user);
        if(i>0){
           return ResultDto.oxOf();
         }
        else{
         return ResultDto.errorOf(500,"操作失败！！！");
        }
    }
}
