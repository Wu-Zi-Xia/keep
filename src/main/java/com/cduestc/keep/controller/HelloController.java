package com.cduestc.keep.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.service.RedisHelloService;
import com.cduestc.keep.service.UserService;
import com.zhenzi.sms.ZhenziSmsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class HelloController {
    @Autowired
    UserService userService;
    @Autowired
    RedisHelloService redisHelloService;
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("/")
    public String hello(HttpServletRequest request, Model model) {
        return "hello";
    }

    @RequestMapping("sendSms")
    @ResponseBody
    public Object sendSms(HttpServletRequest request,
                          @RequestParam(value = "number") String number) throws Exception {
        if(redisHelloService.isEnptyKey(number)){
             return ResultDto.errorOf(500,"不能点击！！");
        }
        JSONObject json;
        String verifyCode = String.valueOf(String.format("%04d",new Random().nextInt(9999)));
        String expireTime = String.valueOf(redisHelloService.setVerifyCode(number, verifyCode));
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "104374", "9d6ba6a4-cb38-4ead-b8fb-7795cf64da68");
        Map<String, String> params = new HashMap<String, String>();
        params.put("message", "验证码为：" + verifyCode+"，过期时间为："+expireTime+"S");
        params.put("number", number);
        String isSuccess = client.send(params);
        json = JSON.parseObject(isSuccess);//json字符串转成json对象
        if (json.getIntValue("code") != 0) {
            return ResultDto.errorOf(500, "验证码发送失败！！");
        }
        ResultDto<String> result = ResultDto.oxOf();
        result.setData(verifyCode);
        return result;
    }

    @RequestMapping("login")
    public @ResponseBody ResultDto loginOrRegister(
            @RequestParam(name = "number") String number,
            @RequestParam(name = "verificationCode") String verificationCode,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        //判断是否过期
        if(redisHelloService.isEnptyKey(number)){
            //判断验证码是否正确
            if(!redisHelloService.isCorrect(number,verificationCode)){
                return ResultDto.errorOf(500,"您输入的验证码有误！！");
            }
            int insert=0;
            //判数据库是否有该用户
            User user = userService.selectUserByNumber(number);
            if(user==null){//当前用户是第一次注册
                //将用户信息插入到数据库中
                 insert= userService.insertUser(number,request.getSession());
            }
           else{
               if(user.getState()==1){//判断用户是否已经登录
                   return ResultDto.errorOf(500,"你已经登录！！");
               }
               else{//没有登录，修改state字段就行了
                   userService.updateStateByNumber(number);
               }
            }
                //向客户端颁发token
                return ResultDto.oxOf(number);
        }
        else{
            return ResultDto.errorOf(500,"验证码过期！！！");
        }
    }
}
