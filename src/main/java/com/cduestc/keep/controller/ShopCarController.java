package com.cduestc.keep.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.AchieveProductDTO;
import com.cduestc.keep.dto.AchieveShopCarProductDto;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.User;
import com.cduestc.keep.model.UserRecord;
import com.cduestc.keep.pojo.Car;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.RedisShopCarService;
import com.cduestc.keep.service.ShopCarService;
import com.cduestc.keep.service.UserRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisShopCarService redisShopCarService;
    @Autowired
    HttpServletRequest request;
    @Value("${cookie.name.preFix}")
    String cookieNamePre;
    @Value("${session.name.preFix}")
    String sessionNamePre;
    @Autowired
    UserRecordService userRecordService;
    @RequestMapping("addShopCar")
    public @ResponseBody Object addShopCar(@RequestBody AchieveShopCarProductDto achieveProductDTO,
                                           HttpServletResponse response,
                                           HttpServletRequest request) throws UnsupportedEncodingException {
        String token = request.getHeader("token");
        User user = (User) request.getSession().getAttribute(sessionNamePre + token);
        //User user =null;
        //从redis中提取购物车
        Car car1 = findCar(request, response);
        //调用服务层操作购物车
        car1 = shopCarService.insertShopCar(car1, achieveProductDTO);
        //可以异步的去插入到userRecord表
        UserRecord userRecord = new UserRecord();
        userRecord.setOwnerId(user.getUserId());
        userRecord.setProductId(achieveProductDTO.getProductId());
        userRecordService.insertUserRecord(userRecord);
        saveCarToRedis(user.getNickname(), car1);
        return ResultDto.oxOf("操作成功");
    }
    //辅助方法提取购物车
    @RequestMapping("findShopCar")
    public @ResponseBody Car findCar( HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        String token = request.getHeader("token");
        User user= (User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
           // String car1String = null;
//        //从cookie中取出购物车
//        Cookie[] cookies = request.getCookies();
//        for (Cookie c : cookies){
//            if (c.getName().equals("car1")){
//                car1String= URLDecoder.decode(c.getValue(),"utf-8");
//            }
//        }
//        if(car1String==null||car1String.equals("")){
//            car1String="{}";
//        }
//        //JSON字符串转java对象
//        Car carFromCookie = JSON.parseObject(car1String, Car.class);
//        if(user==null){//session中没有值，用户没有登录，从cookie中去取购物车
//            return carFromCookie;
            //session中有值，用户登录，从redis中去取购物车
            Car carFromRedis = findCarFromRedis(user.getNickname());
           // Car mergeCar = shopCarService.mergeShopCar(carFromCookie, carFromRedis);
            //saveCarToRedis(user.getNickname(),mergeCar);
            //删除本地购物车
//            Cookie cookie1=new Cookie("car1",null);
//            cookie1.setMaxAge(0);
//            response.addCookie(cookie1);
            return carFromRedis;
    }
    //从redis中取出购物车
    public  Car findCarFromRedis(String userName){
        Car shopCar =(Car) redisTemplate.boundHashOps("shopCar").get(userName);
        if(shopCar==null){
           shopCar=new Car();
         }
        return shopCar;
    }

    public void saveCarToRedis(String userName,Car car){
      redisTemplate.boundHashOps("shopCar").put(userName,car);
    }
}
