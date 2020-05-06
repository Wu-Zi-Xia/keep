package com.cduestc.keep.controller;

import com.cduestc.keep.dto.AchieveOrderDto;
import com.cduestc.keep.dto.DeliverOrderDto;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.User;
import com.cduestc.keep.model.UserRecord;
import com.cduestc.keep.provider.UserRecordInsertParam;
import com.cduestc.keep.service.OrderService;
import com.cduestc.keep.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @Autowired
    UserRecordService userRecordService;
    @RequestMapping("createOrder")
    @ResponseBody
    public Object createOrder(@RequestBody AchieveOrderDto achieveOrderDto, HttpServletRequest request){
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){//判断用户是否登录
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        String order = orderService.createOrder(achieveOrderDto, user);
        //可以异步的去添加到userRecord里面
        UserRecordInsertParam userRecord=new UserRecordInsertParam();
        userRecord.setProductIds(achieveOrderDto.getIds());
        userRecord.setOwnerId(user.getUserId());
        userRecordService.insertUserRecord(userRecord);
        return ResultDto.oxOf(order);
    }
    @RequestMapping("getOrders")
    @ResponseBody
    public Object getOrder(HttpServletRequest request,
                           @RequestParam(name = "page",defaultValue = "1") long page,
                           @RequestParam(name="size",defaultValue ="20") long size,
                           @RequestParam(value = "type",required = false) Integer type){

        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){//判断用户是否登录
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }

        List<DeliverOrderDto> orders = orderService.getOrders(page, size, user.getUserId(),type);
        return ResultDto.oxOf(orders);
    }
}
