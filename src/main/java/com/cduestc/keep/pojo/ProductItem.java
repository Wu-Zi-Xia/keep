package com.cduestc.keep.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductItem implements Serializable {
    private Long id;
    private String productName;//商品名字
    private Double price;//价格
    private String resourceUrl;//商品图片地址
    private int number;//几个商品
    private Double totalFee;//总价值
    private JSON productSpecs;//规格
}
