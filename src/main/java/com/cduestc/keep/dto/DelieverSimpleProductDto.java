package com.cduestc.keep.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class DelieverSimpleProductDto {
    private Long id;
    private String name;
    private String urls;
    private String description;
    private String price;
}
