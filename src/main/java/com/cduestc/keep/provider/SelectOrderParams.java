package com.cduestc.keep.provider;

import lombok.Data;

@Data
public class SelectOrderParams {
    private long offset;
    private long size;
    private long userId;
    private Integer status;
}
