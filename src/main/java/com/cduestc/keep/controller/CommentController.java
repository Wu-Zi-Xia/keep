package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchieveCommentDTO;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    CommentService commentService;

    @RequestMapping("createComment")
    public Object createComment(HttpServletRequest request, @RequestBody AchieveCommentDTO achieveCommentDTO){
        int i = commentService.insertComment(request, achieveCommentDTO);
        if(i>0){
            return ResultDto.oxOf();
        }
        return ResultDto.errorOf(500,"评论失败！！");
    }
}
