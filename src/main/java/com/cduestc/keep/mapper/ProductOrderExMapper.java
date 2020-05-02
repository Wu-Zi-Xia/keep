package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Order;
import com.cduestc.keep.model.ProductOrder;
import com.cduestc.keep.provider.SelectOrderParams;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface ProductOrderExMapper {
    List<ProductOrder> selectOrdersByUserIdLimit(SelectOrderParams selectOrderParams);

    long countByUserId(@Value("userId") long userId);
}
