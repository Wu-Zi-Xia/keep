package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.CheckIn;
import com.cduestc.keep.model.User;
import com.cduestc.keep.service.CheckInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Slf4j
@Controller
public class CheckInController {
    @Autowired
    CheckInService checkInService;
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("checkIn")
    public @ResponseBody Object checkIn(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(redisTemplate.hasKey("checkIn:"+user.getUserId())){
            //表示今天已经签到
            if(redisTemplate.opsForValue().get("checkIn:"+user.getUserId()).equals("1")){
                return ResultDto.oxOf("今天已经签过到了！！！");
            }
        }
        else{
            int i = checkInService.checkIn(request);
            if(i==0){
                return ResultDto.oxOf("今天已经签过到了！！！");
            }
        }
            return ResultDto.oxOf("签到成功！！");
    }

     @RequestMapping("getCheckIn")
     public @ResponseBody Object getCheckIn(@RequestParam("month") String month, HttpServletRequest request){
     List<CheckIn> checkIn = checkInService.getCheckIn(month, request);
     if((checkIn==null)){
        return ResultDto.errorOf(500,"获取签到列表失败！！，（那个时候我们还没有相识呢！！）");
     }
     return ResultDto.oxOf(checkIn);

}



}
