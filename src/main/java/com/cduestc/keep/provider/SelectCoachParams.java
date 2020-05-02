package com.cduestc.keep.provider;

import lombok.Data;

import java.util.List;

@Data
public class SelectCoachParams {
    private long offset;
    private long size;
    private List<Long> ids;
}
