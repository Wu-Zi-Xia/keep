package com.cduestc.keep.service;

import com.cduestc.keep.dto.AchieveOrderDto;
import com.cduestc.keep.dto.DeliverOrderDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.*;
import com.cduestc.keep.model.*;
import com.cduestc.keep.provider.ProviderOrderId;
import com.cduestc.keep.provider.SelectOrderParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    ProductOrderMapper orderMapper;
    @Autowired
    OrderShippingMapper orderShippingMapper;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Resource
    ProviderOrderId providerOrderId;
    @Autowired
    OrderExMapper orderExMapper;
    public String createOrder(AchieveOrderDto achieveOrderDto, User user) {
        //生成一个订单的id
        String orderId = providerOrderId.getOrderId();
        ProductOrder order=achieveOrderDto.getOrder();
        //然后向订单表中插入数据
        order.setId(Long.parseLong(orderId));
        //订单状态：状态：1、未付款，2、已付款，3、未发货，4、已发货
        //判断用户是已经支付还是没有支付
        if(achieveOrderDto.getIsPayed()==1){
            order.setStatus(1);
        }
        else {
            order.setStatus(2);
            order.setCreateDate(System.currentTimeMillis());
        }
        order.setBuyerRate(0);
        order.setUserId(user.getUserId());
        order.setCreateDate(System.currentTimeMillis());
        order.setModifyDate(System.currentTimeMillis());
        order.setBuyerNick(user.getNickname());
        //补全完信息后，插入数据库表
        orderMapper.insert(order);
        //补全订单详情表
        //因为传递过来的是一个集合列表，所以遍历列表
        String orderItemId = providerOrderId.getOrderItemId();
        for (OrderItem tbOrderItem :achieveOrderDto.getOrderItems() ) {
            tbOrderItem.setId(Long.parseLong(orderItemId));
            tbOrderItem.setOrderId(Long.parseLong(orderId));
            orderItemMapper.insert( tbOrderItem);
        }
        OrderShipping orderShipping=achieveOrderDto.getOrderShipping();
        //接下来补全订单配送表
        orderShipping.setOrderId(Long.parseLong(orderId));
        orderShipping.setCreateDate(System.currentTimeMillis());
        orderShipping.setModifyDate(System.currentTimeMillis());
        orderShippingMapper.insert(orderShipping);
        return orderId;
    }

    public List<DeliverOrderDto> getOrders(long page,long size,long userId,Integer type){
        //获取当前用户所有的订单数量
        long totalCount = orderExMapper.countByUserId(userId);
        long j= totalCount%size;
        long mysqlPage=0;
        if(j>0){//如果有余数
            mysqlPage=totalCount/size+1;
        }
        if(j==0){//没有余数
            mysqlPage=totalCount/size;
        }
        if(page>mysqlPage){//说明已经到底了
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
        List<DeliverOrderDto> deliverOrderDtos=new ArrayList<>();
        long offset=size*(page-1);
        SelectOrderParams selectOrderParams=new SelectOrderParams();
        selectOrderParams.setOffset(offset);
        selectOrderParams.setSize(size);
        selectOrderParams.setUserId(userId);
        //订单状态：状态：1、未付款，2、已付款，3、未发货，4、已发货
        //按照订单状态查询订单
        if(type!=null){
        switch (type){
           case 1:
               selectOrderParams.setStatus(1);
               break;
           case 2:
               selectOrderParams.setStatus(2);
               break;
           case 3:
               selectOrderParams.setStatus(3);
               break;
           case 4:
               selectOrderParams.setStatus(4);
               break;
       }
        }
        List<ProductOrder> orders = orderExMapper.selectOrdersByUserIdLimit(selectOrderParams);
        Iterator<ProductOrder> iterator = orders.iterator();
        while(iterator.hasNext()){
            DeliverOrderDto deliverOrderDto=new DeliverOrderDto();
            ProductOrder next = iterator.next();
            //设置order
            deliverOrderDto.setOrder(next);
            OrderItemExample orderItemExample=new OrderItemExample();
            orderItemExample.createCriteria().andOrderIdEqualTo(next.getId());
            List<OrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
            //设置订单详情
            deliverOrderDto.setOrderItems(orderItems);
            OrderShippingExample orderShippingExample=new OrderShippingExample();
            orderShippingExample.createCriteria().andOrderIdEqualTo(next.getId());
            List<OrderShipping> orderShippings = orderShippingMapper.selectByExample(orderShippingExample);
            //设置订单的接收者
            deliverOrderDto.setOrderShipping(orderShippings.get(0));
            deliverOrderDtos.add(deliverOrderDto);
        }
        return deliverOrderDtos;
    }

}
