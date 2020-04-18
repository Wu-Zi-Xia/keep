package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchieveSportsHistoryDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.RedisSportsHistoryService;
import com.cduestc.keep.service.SportsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SportsHistoryController {
    @Autowired
    SportsHistoryService sportsHistoryService;

    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @Value("redis.keep.history")
    private String redisSportsHistory;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisSportsHistoryService redisSportsHistoryService;

    @RequestMapping("insertSportsHistory")
     public @ResponseBody void insertSportsHistory(@RequestBody AchieveSportsHistoryDto achieveSportsHistoryDto,
                             HttpServletRequest request){
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        sportsHistoryService.insertSportsHistory(achieveSportsHistoryDto,user);
     }
     public @ResponseBody Object getSportsHistory(HttpServletRequest request){
         String token = request.getHeader("token");
         User user = (User) request.getSession().getAttribute(sessionNamePre + token);

         if(redisTemplate.hasKey(redisSportsHistory+user.getUserId())){
             //redisSportsHistoryService.getHistoryService();
         }
         return null;
     }
}
