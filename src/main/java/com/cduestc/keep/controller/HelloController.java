package com.cduestc.keep.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.service.RedisHelloService;
import com.cduestc.keep.service.UserService;
import com.zhenzi.sms.ZhenziSmsClient;
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

@Controller
public class HelloController {
    @Autowired
    UserService userService;
    @Autowired
    RedisHelloService redisHelloService;

    @RequestMapping("/")
    public String hello(HttpServletRequest request, Model model) {
        return "hello";
    }

    @RequestMapping("sendSms")
    @ResponseBody
    public Object sendSms(HttpServletRequest request,
                          @RequestParam(value = "number") String number) throws Exception {

        JSONObject json;
        String verifyCode = String.valueOf(new Random().nextInt() + 100000);
        String expireTime = String.valueOf(redisHelloService.setVerifyCode(number, verifyCode));
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "104374", "9d6ba6a4-cb38-4ead-b8fb-7795cf64da68");
        Map<String, String> params = new HashMap<String, String>();
        params.put("message", "验证码为：" + verifyCode+"，过期时间为："+expireTime);
        params.put("number", number);
        String isSuccess = client.send(params);
        json = JSON.parseObject(isSuccess);//json字符串转成json对象
        if (json.getIntValue("code") != 0) {
            return ResultDto.errorOf(433, "验证码发送失败！！");
        }
        ResultDto<String> result = ResultDto.oxOf();
        result.setData(verifyCode);
        return result;
    }

    @RequestMapping("login")
    public @ResponseBody ResultDto loginOrRegister(@RequestParam(name = "number") String number,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        if(!redisHelloService.isEnptyKey(number)){
            int insert = userService.insertUser(number,request.getSession());
            if(insert>0){
                response.addCookie(new Cookie("number",number));
                return ResultDto.oxOf("主页的url地址");
            }
        }
        else{
            return ResultDto.errorOf(500,"验证码过期！！！");
        }

        return ResultDto.errorOf(500,"注册失败！！");
    }
}
