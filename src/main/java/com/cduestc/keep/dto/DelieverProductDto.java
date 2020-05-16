package com.cduestc.keep.dto;

import com.alibaba.fastjson.JSON;
import com.cduestc.keep.model.ProductSpecs;
import lombok.Data;

import java.util.List;

@Data
public class DelieverProductDto {
    private Long id;
    private Long categoryId;
    private JSON publicAttribute;
    private JSON attributeList;
    private Long createDate;
    private Long modifyDate;
    private String price;
    private String name;
    private String description;
    private Integer sellerCount;
    private String[] urls;
    private List<ProductSpecs> productSpecsList;


}
