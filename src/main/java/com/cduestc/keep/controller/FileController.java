package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchieveUserINFO;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.FileService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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
    @Autowired
    FileService fileService;
    @RequestMapping("updateUserINFO")
    public @ResponseBody
    Object updateUserINFO(HttpServletRequest request, @RequestBody AchieveUserINFO achieveUserINFO){
        String token = request.getHeader("token");
        User user = (User)request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        int update = userService.update(achieveUserINFO,user.getUserId());

        if(update>0){
            return ResultDto.oxOf("修改成功！！！");
        }
        else{
            return ResultDto.errorOf(500,"修改失败");
        }
    }
    @ResponseBody//此接口返回的数据是json格式的
    @RequestMapping("updateAvatarURL")
    public Object updateUserAvatarURL(HttpServletRequest request) throws IOException {
        String token = request.getHeader("token");
        //获取登录的用户id
        User user = (User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
       // int contentLength = request.getContentLength();
        MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
        MultipartFile file=multipartHttpServletRequest.getFile("avatarURL");
        if(file.isEmpty()){
            throw new CustomizeException(CustomizeErrorCode.RESOURCE_IS_NULL);
        }
        int update = fileService.update(user.getUserId(), file);
        if(update>0){
            return  ResultDto.oxOf("修改成功！！");
        }
        return ResultDto.errorOf(500,"修改失败!!");
    }

}
