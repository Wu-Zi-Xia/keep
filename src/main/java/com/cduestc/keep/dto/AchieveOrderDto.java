package com.cduestc.keep.dto;

import com.cduestc.keep.model.*;
import lombok.Data;

import java.util.List;

@Data
public class AchieveOrderDto {
    private List<Long> ids;
    private ProductOrder order;
    private List<OrderItem> orderItems;
    private OrderShipping orderShipping;
    private int isPayed;
//    private Double payment;
//    private Integer paymentType;
//    private Double postFee;
//    private Long paymentDate;
//    private String shippingName;
//    private String shippingCode;
//    private String buyerMessage;
//    private Integer buyerRate;
    //订单详情信息

    //订单配送信息

}
