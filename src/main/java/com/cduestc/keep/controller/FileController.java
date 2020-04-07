package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.xerces.impl.dv.dtd.IDDatatypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

//关于图片的上传和下载功能
@Controller
public class FileController {
@Autowired
    UserService userService;
@RequestMapping("updateAvatarURL")
    public Object updateAvatarURL(HttpServletRequest request, @Param("avatarURL")String avatarURL){
        User user = (User) request.getSession().getAttribute("user");
        Long ID=user.getUserId();
        if(user==null){
            return null;
        }
        int update = userService.update(ID, avatarURL);

        if(update>0){
            return ResultDto.oxOf("修改成功！！！");
        }
        else{
            return ResultDto.errorOf(500,"修改失败");
        }
    }
}
