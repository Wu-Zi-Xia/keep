package com.cduestc.keep.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Car implements Serializable {
     private long id;//没有具体到规格的商品的id
     private String sellerName;//商家名字
     private List<ProductItem> productItems;//购物车明细
}
