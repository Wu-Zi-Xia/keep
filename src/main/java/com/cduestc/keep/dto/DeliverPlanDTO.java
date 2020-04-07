package com.cduestc.keep.dto;

import com.cduestc.keep.provider.Sports;
import lombok.Data;

import java.util.List;

@Data
public class DeliverPlanDTO {
    private Long planId;
    private List<Sports> sports;
    private int state;
    private boolean isCurrent;
}
