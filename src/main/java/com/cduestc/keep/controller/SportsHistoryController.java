package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchieveSportsHistoryDto;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.SportsData;
import com.cduestc.keep.model.SportsHistory;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.RedisSportsHistoryService;
import com.cduestc.keep.service.SportsDataService;
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
import java.util.List;

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
    @Autowired
    SportsDataService sportsDataService;
    @RequestMapping("insertSportsHistory")
     public @ResponseBody Object insertSportsHistory(@RequestBody AchieveSportsHistoryDto achieveSportsHistoryDto,
                             HttpServletRequest request){
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        sportsHistoryService.insertSportsHistory(achieveSportsHistoryDto,user);
        return ResultDto.oxOf();
     }
     @RequestMapping("getSportsData")
     public @ResponseBody Object getSportsData(HttpServletRequest request){
         String token = request.getHeader("token");
         User user =(User) request.getSession().getAttribute(sessionNamePre + token);
         if(user==null){
             throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
         }
         SportsData sportsData = sportsDataService.getSportsData(user.getUserId());
         return ResultDto.oxOf(sportsData);
     }
    @RequestMapping("getSportsHistory")
     public @ResponseBody Object getSportsHistory(HttpServletRequest request){
         String token = request.getHeader("token");
         User user = (User) request.getSession().getAttribute(sessionNamePre + token);
         if(user==null){
             throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
         }
         if(redisTemplate.hasKey(redisSportsHistory+user.getUserId())){
             //redisSportsHistoryService.getHistoryService();
         }
         else{
             List<SportsHistory> sportsHistoryById =
                     sportsHistoryService.getSportsHistoryById(user.getUserId());
             return ResultDto.oxOf(sportsHistoryById);
         }
         return null;
     }
}
