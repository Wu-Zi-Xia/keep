package com.cduestc.keep.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Car implements Serializable {

     private String sellerName;//商家名字
     private List<ProductItem> productItems;//购物车明细
}
