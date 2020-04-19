package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class AchieveShopCarProductDto {
    private  Long id;
    //private String description;
    //private String name;
    private Long  productId;//属于哪一个产品
    //private String  productSpecs;
    //private String productPrice;
    private int number;//商品个数
}
