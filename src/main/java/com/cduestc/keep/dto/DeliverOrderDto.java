package com.cduestc.keep.dto;

import com.cduestc.keep.model.Order;
import com.cduestc.keep.model.OrderItem;
import com.cduestc.keep.model.OrderShipping;
import lombok.Data;

import java.util.List;
@Data
public class DeliverOrderDto {
    private Order order;
    private List<OrderItem> orderItems;
    private OrderShipping orderShipping;
}
