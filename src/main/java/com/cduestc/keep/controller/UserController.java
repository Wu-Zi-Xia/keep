package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
@Slf4j
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @RequestMapping("getUserINFO")
    public @ResponseBody Object getUserINFO(HttpServletRequest request){
        Cookie cookie = CookieProvider.getCookie(request.getCookies(), cookieNamePre);
        User user =(User) request.getSession().getAttribute(sessionNamePre+cookie.getValue());
        if(user==null){
            return ResultDto.errorOf(500,"用户不存在！！");
        }
        User user1 = userService.selectUserINFO(user.getUserId());
        return ResultDto.oxOf(user1);
    }

}
