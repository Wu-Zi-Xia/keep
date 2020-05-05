package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class AchieveShopCarProductDto {
    //具体到哪一个规格的商品
    private  Long id;
    private Long  productId;//属于哪一个（总的）产品
    private int number;//商品个数
}
