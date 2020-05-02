package com.cduestc.keep.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductSimpleINFO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String urls;
    private String price;
}
