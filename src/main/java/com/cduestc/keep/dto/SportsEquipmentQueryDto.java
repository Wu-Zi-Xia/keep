package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class SportsEquipmentQueryDto {
    private int offset;
    private int limit;
    private String search;
    private String type;
}
