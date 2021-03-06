package com.cduestc.keep.controller;

import com.cduestc.keep.dto.DeliverSimpleUserINFODTO;
import com.cduestc.keep.dto.DeliverUserINFODto;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.List;

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
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre+token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        DeliverUserINFODto deliverUserINFODto = userService.selectUserINFO(user.getUserId());
        return ResultDto.oxOf(deliverUserINFODto);
    }
    @RequestMapping("getSex")
     public @ResponseBody Object  getSex(HttpServletRequest request){
        String token = request.getHeader("token");
         User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
         String sexById = userService.getSexById(user);
         return ResultDto.oxOf(sexById);
     }
     @RequestMapping("searchUser")
    public @ResponseBody  Object searchUser(HttpServletRequest request,
                                            @RequestParam(name = "search") String search){
        if(search==null){
            throw new CustomizeException(CustomizeErrorCode.SEARCH_IS_ENPTY);
        }
         String token = request.getHeader("token");
         User user =(User) request.getSession().getAttribute(sessionNamePre + token);
         if(user==null){
             throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
         }
         List<DeliverSimpleUserINFODTO> deliverSimpleUserINFODTOS = userService.searchUser(user, search);
         if(deliverSimpleUserINFODTOS.size()==0){
             throw new CustomizeException(CustomizeErrorCode.USER_IS_NOT_FOUND);
         }
         return ResultDto.oxOf(deliverSimpleUserINFODTOS);
     }
     @RequestMapping("getFans")
     @ResponseBody
    public Object getFans(HttpServletRequest request){
         String token = request.getHeader("token");
         User user =(User) request.getSession().getAttribute(sessionNamePre + token);
         if(user==null){
             throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
         }
         List<DeliverSimpleUserINFODTO> fans = userService.getFans(user.getUserId());
         if(fans.size()==0){
             throw new CustomizeException(CustomizeErrorCode.NOT_HAVE_FANS);
         }
         return ResultDto.oxOf(fans);
     }
    @RequestMapping("getFocus")
    @ResponseBody
    public Object getFocus(HttpServletRequest request){
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        List<DeliverSimpleUserINFODTO> focus = userService.getFocus(user.getUserId());
        if(focus.size()==0){
            throw new CustomizeException(CustomizeErrorCode.NOT_HAVE_FOCUS);
        }
        return ResultDto.oxOf(focus);
    }
}
