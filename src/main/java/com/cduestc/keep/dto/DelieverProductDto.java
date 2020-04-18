package com.cduestc.keep.dto;

import com.alibaba.fastjson.JSON;
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
    private String[] urls;



}
