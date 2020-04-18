package com.cduestc.keep.controller;

import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.CheckIn;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.CheckInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class CheckInController {
    @Autowired
    CheckInService checkInService;
    @Autowired
    RedisTemplate redisTemplate;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @RequestMapping("checkIn")
    public @ResponseBody Object checkIn(HttpServletRequest request){
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre +token);
        ResultDto resultDto=new ResultDto();
        if(redisTemplate.hasKey("checkIn:"+user.getUserId())){//redis中是否有已经签到的标志位
            //表示今天已经签到
            if(redisTemplate.opsForValue().get("checkIn:"+user.getUserId()).equals("1")){
                resultDto.setData(false);
                resultDto.setMessage("今天已经签过到！！");
                resultDto.setCode(200);
                return resultDto;
            }
        }
        else{//没有就到数据库里面去签到，如果已经签到
            int i = checkInService.checkIn(request);
            if(i==0){
                //同步redis中
                redisTemplate.opsForValue().set("checkIn:"+user.getUserId(),"1",1l, TimeUnit.MINUTES);
                resultDto.setData(false);
                resultDto.setMessage("今天已经签过到！！");
                resultDto.setCode(200);
                return resultDto;
            }
        }
            resultDto.setCode(200);
            resultDto.setData(false);
            resultDto.setMessage("签到成功！！");
            return resultDto;
    }

     @RequestMapping("getCheckIn")
     public @ResponseBody Object getCheckIn(@RequestParam("month") String month, HttpServletRequest request){
        //获取当前系统时间的month
         Calendar calendar1 = Calendar.getInstance();
         String pattern = "yyyy-MM";
         SimpleDateFormat stf = new SimpleDateFormat(pattern);
         String systemMonth = stf.format(calendar1.getTime());
         int numSystemMonth = Integer.parseInt(systemMonth.substring(systemMonth.length() - 1));
         int numMonth = Integer.parseInt(systemMonth.substring(month.length() - 1));
         String token=request.getHeader("token");
         User user
                 = (User) request.getSession().getAttribute(sessionNamePre +token);
         List<CheckIn> checkIn = checkInService.getCheckIn(month, user);
     if((checkIn==null||checkIn.size()==0)){//判断签到的信息

        return ResultDto.errorOf(500,"获取签到列表失败！！，（那个时候我们还没有相识呢！！）");
     }
     return ResultDto.oxOf(checkIn);

}



}
