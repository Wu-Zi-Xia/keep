package com.cduestc.keep.provider;

import lombok.Data;

import java.util.List;

@Data
public class ProductSelectParam {
    private int offset;
    private int size;
    private List<Long> ids;
}
