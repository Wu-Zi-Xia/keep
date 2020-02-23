package com.cduestc.keep.controller;

import com.cduestc.keep.dto.CommunityDto;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommunityController {
    @Autowired
    CommunityService communityService;
    @RequestMapping("getFriendPost")
    @ResponseBody
    //获取关注的朋友的动态
    public Object getFriendPost(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        List<CommunityDto> friendPosts = communityService.getFriendPost(session);
        ResultDto resultDto = ResultDto.oxOf(friendPosts);
        return  resultDto;
    }

}
