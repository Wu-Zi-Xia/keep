package com.cduestc.keep.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.AchieveProductDTO;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.User;
import com.cduestc.keep.pojo.Car;
import com.cduestc.keep.service.RedisShopCarService;
import com.cduestc.keep.service.ShopCarService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("addShopCar")
    public @ResponseBody Object addShopCar(@RequestBody AchieveProductDTO achieveProductDTO,HttpServletResponse response){
        try {
            User user =(User) request.getSession().getAttribute("user");
            //User user =null;
            //提取购物车
            Car car1 = findCar(request,response);
            //调用服务层操作购物车
            car1 = shopCarService.insertShopCar(car1, achieveProductDTO);
            //将购物车重新放入到介质中（redis或者是cookie）
            if(user==null){//用户没有登录
                String car1String =URLEncoder.encode(JSON.toJSONString(car1),"utf-8");
                Cookie car1Cookie = new Cookie("car1", car1String);
                car1Cookie.setMaxAge(3600*24);
                response.addCookie(car1Cookie);
                return ResultDto.oxOf("操作成功！！");
            }else{//用户已经登录，直接存入redis中
                saveCarToRedis(user.getNickname(),car1);
                return ResultDto.oxOf("操作成功！！");
            }
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.errorOf(500,"操作失败！！");
        }

    }
    //辅助方法提取购物车
    @RequestMapping("findShopCar")
    public @ResponseBody Car findCar( HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        User user =(User) request.getSession().getAttribute("user");
        String car1String = null;
        //从cookie中取出购物车
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies){
            if (c.getName().equals("car1")){
                car1String= URLDecoder.decode(c.getValue(),"utf-8");
            }
        }
        if(car1String==null||car1String.equals("")){
            car1String="{}";
        }
        //JSON字符串转java对象
        Car carFromCookie = JSON.parseObject(car1String, Car.class);

        if(user==null){//session中没有值，用户没有登录，从cookie中去取购物车
            return carFromCookie;
        }else{//session中有值，用户登录，从redis中去取购物车
            Car carFromRedis = findCarFromRedis(user.getNickname());
            Car mergeCar = shopCarService.mergeShopCar(carFromCookie, carFromRedis);
            saveCarToRedis(user.getNickname(),mergeCar);
            //删除本地购物车
           Cookie cookie=new Cookie("car1",null);
           cookie.setMaxAge(0);
            response.addCookie(cookie);
            //返回
            return mergeCar;
        }
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
