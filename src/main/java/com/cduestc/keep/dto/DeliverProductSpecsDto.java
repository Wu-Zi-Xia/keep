package com.cduestc.keep.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class DeliverProductSpecsDto {
    private Long id;
    private Long productId;
    private JSON productSpecs;
    private Integer productStock;
    private Double productPrice;
    private Integer status;
    private String url;
}
