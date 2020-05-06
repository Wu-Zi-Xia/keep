package com.cduestc.keep.dto;

import com.cduestc.keep.model.Order;
import com.cduestc.keep.model.OrderItem;
import com.cduestc.keep.model.OrderShipping;
import com.cduestc.keep.model.ProductOrder;
import lombok.Data;

import java.util.List;
@Data
public class DeliverOrderDto {
    private ProductOrder order;
    private List<OrderItem> orderItems;
    private OrderShipping orderShipping;
}
