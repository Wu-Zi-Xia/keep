package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchieveCommentDTO;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Slf4j
@Controller
public class CommentController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    CommentService commentService;
    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @Value("${redis.keep.FriCirMyFriend}")
    String redisFriTableNameF;
    @Value("${redis.keep.FriCirMyFriendSort}")
    String redisFriCriSortSetF;
    @RequestMapping("createComment")
    public @ResponseBody Object createComment(HttpServletRequest request, @RequestBody AchieveCommentDTO achieveCommentDTO){
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        int i = commentService.insertComment(user, achieveCommentDTO);
        if(i>0){
            return ResultDto.oxOf();
        }
        return ResultDto.errorOf(500,"评论失败！！");
    }
}
