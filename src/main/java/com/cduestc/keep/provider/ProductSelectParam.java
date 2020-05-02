package com.cduestc.keep.provider;

import lombok.Data;

import java.util.List;

@Data
public class ProductSelectParam {
    private long offset;
    private long size;
    private String search;
    private List<Long> ids;
}
