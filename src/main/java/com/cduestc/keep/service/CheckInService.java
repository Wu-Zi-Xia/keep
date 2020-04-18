package com.cduestc.keep.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.mapper.CheckInMapper;
import com.cduestc.keep.model.CheckIn;
import com.cduestc.keep.model.CheckInExample;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CheckInService {
    @Autowired
    CheckInMapper checkInMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Value("${cookie.name.preFix}")
    String cookieName;
    @Value("${session.name.preFix}")
    String sessionName;
//签到逻辑，接口直接调用
    public int checkIn(HttpServletRequest request) {
        Cookie cookie = CookieProvider.getCookie(request.getCookies(), cookieName);
        User user = (User)request.getSession().getAttribute(sessionName + cookie.getValue());
        Long userId = user.getUserId();
        //获取系统当前的月和天
        Calendar calendar1 = Calendar.getInstance();
        String pattern = "yyyy-MM";
        SimpleDateFormat stf = new SimpleDateFormat(pattern);
        String month = stf.format(calendar1.getTime());
        //获取当前日期在所在月份的第几天
        int days = calendar1.get(Calendar.DAY_OF_MONTH);
        if( isSigned(user,days)){

            return 0;
        }
        //获取系统的年份和月份来计算每月有多少天，用来设置数组的长度
        int year = calendar1.get(Calendar.YEAR);
        int months = calendar1.get(Calendar.MONTH);
        calendar1.set(Calendar.YEAR, year);
        calendar1.set(Calendar.MONTH, months);
        int maxDays = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置签到的信息的数组
        int[] results = new int[maxDays];
        results[days-1]  = 1;
        //需要在此将数组转为String进行存储
        String jsonString = JSONObject.toJSONString(results);
        if((days-1) == 0) {//0表示数组的第一个数，表示每月的第一天
        //生成主键ID
         //Long id = SequenceUtil.create().sequenceNextVal("fl_user_sign");
         //data.put("ID", id);
          //封装用户实体类
          CheckIn userSign = new CheckIn();
          userSign.setOwnerId(userId);
          userSign.setMonth(month);
          userSign.setResults(jsonString);
          //签到
         //logger.info("用户中心", "签到的provider：提交签到", false,"月初第一次签到："+ JsonUtils.objectToJson(userSign));

         //定义连续签到的天数
        int conSigns = 1;
        userSign.setContinueSign(conSigns);
        //签到信息插入数据库
        checkInMapper.insert(userSign);
        //同步redis中
            redisTemplate.opsForValue().set("checkIn:"+user.getUserId(),"1",1l, TimeUnit.MINUTES);
        //map.put("conSigns", conSigns);
        }
        else{
            //判断连续签到几天，需要取到当月签到的列表，判断前一天是否签到，如果昨天签到就在签到总天数加1，否则就置为1
            CheckInExample checkInExample=new CheckInExample();
            CheckInExample.Criteria criteria = checkInExample.createCriteria().andOwnerIdEqualTo(userId);
            criteria.andMonthEqualTo(month);
            //获取签到信息
            List<CheckIn> checkIns = checkInMapper.selectByExample(checkInExample);
            //如果checkIns为空，说明1号没有签到，这里需要重新生成一条数据插入到数据库中
             if(checkIns.size()==0){
                 CheckIn userSign = new CheckIn();
                 userSign.setOwnerId(userId);
                 userSign.setMonth(month);
                 userSign.setResults(jsonString);

                 //logger.info("用户中心", "签到的provider：提交签到", false,"月初第一次签到："+ JsonUtils.objectToJson(userSign));

                 //定义连续签到的天数
                 int conSigns = 1;
                 userSign.setContinueSign(conSigns);
                 //签到
                 checkInMapper.insert(userSign);
                 //同步redis中
                 redisTemplate.opsForValue().set("checkIn:"+user.getUserId(),"1",1l, TimeUnit.MINUTES);
             }
             else {//说明一号已经签到了
                 //现在判断连续签到的天数
                  String resultsString=checkIns.get(0).getResults();
                 //将string类型和JSONArray进行互相转换
                 JSONArray parseArray = JSONObject.parseArray(resultsString);
                 //对于拿到的签到数组进行判断，计算连续签到的天数
                 int conSigns = 1;
                 //对于拿到的签到数组进行判断，计算连续签到的天数
                 for(int i=(days-2);i>=0;i--) {
                     Byte signs = parseArray.getByte(i);
                     //如果是前一天没有签到就返回签到一天
                     if(signs == 0 && i == (days-2)) {
                     //map.put("conSigns", conSigns);
                      break;
                       }
                if(signs == 1) {
               //在此判断连续的天数 
                  conSigns += 1;
                 //map.put("conSigns", conSigns);
                }
                //如果未签到不是昨天的情况，退出循环
                if(signs == 0 && i != (days-2)) {
                  break;
              }

              }
                 //将今天的数据插入到数组中，在原来的数组里进行update操作
                 parseArray.set(days-1, 1);
                 //将数组转换为String
                 String jsonString2 = parseArray.toJSONString();
                 CheckInExample checkInExample1=new CheckInExample();
                 checkInExample1.createCriteria().andOwnerIdEqualTo(userId);
                 CheckIn checkIn=new CheckIn();
                 checkIn.setResults(jsonString2);
                 checkInMapper.updateByExampleSelective(checkIn,checkInExample1);
                 //同步redis中
                 redisTemplate.opsForValue().set("checkIn:"+user.getUserId(),"1",1l, TimeUnit.MINUTES);
             }
        }
         return 1;
    }

    //按照月份和用户的ID获取到这个月的签到列表
    public List<CheckIn> getCheckIn(String month, User user) {
        CheckInExample checkInExample=new CheckInExample();
        CheckInExample.Criteria criteria = checkInExample.createCriteria().andOwnerIdEqualTo(user.getUserId());
        criteria.andMonthEqualTo(month);
        List<CheckIn> checkIns = checkInMapper.selectByExample(checkInExample);
        return checkIns;
    }


    public boolean isSigned(User user,int index){
        Long userId = user.getUserId();
        //获取系统当前的月和天
        Calendar calendar1 = Calendar.getInstance();
        String pattern = "yyyy-MM";
        SimpleDateFormat stf = new SimpleDateFormat(pattern);
        String month = stf.format(calendar1.getTime());
        CheckInExample checkInExample=new CheckInExample();
        CheckInExample.Criteria criteria = checkInExample.createCriteria().andOwnerIdEqualTo(userId);
        criteria.andMonthEqualTo(month);
        //获取签到信息
        List<CheckIn> checkIns = checkInMapper.selectByExample(checkInExample);
        if(checkIns==null){
            return false;
        }
        else{
            String resultsString=checkIns.get(0).getResults();
            //将string类型和JSONArray进行互相转换
            JSONArray parseArray = JSONObject.parseArray(resultsString);
            Byte signs = parseArray.getByte(index-1);
               if(signs==1){
                   return true;
               }
        }
        return false;
    }

}
