package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchieveUserINFO;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.xerces.impl.dv.dtd.IDDatatypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Slf4j
//关于图片的上传和下载功能
@Controller
public class FileController {
    @Autowired
    UserService userService;
    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @RequestMapping("updateUserINFO")
    public @ResponseBody
    Object updateUserINFO(HttpServletRequest request, @RequestBody AchieveUserINFO achieveUserINFO){
        String token = request.getHeader("token");
        User user = (User)request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        int update = userService.update(achieveUserINFO,user.getUserId());
       if(update==4500){
           return ResultDto.errorOf(1009,"昵称已经存在！！！");
         }
        if(update>0){
            return ResultDto.oxOf("修改成功！！！");
        }
        else{
            return ResultDto.errorOf(500,"修改失败");
        }
    }
}
