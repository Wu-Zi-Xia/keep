package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("getUserINFO")
    public Object getUserINFO(HttpServletRequest request){
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }
        User user1 = userService.selectUserINFO(user.getUserId());
        return ResultDto.oxOf(user1);
    }
}
