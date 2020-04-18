package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class AchieveSportsHistoryDto {
    private Long sportsId;
    private String type;
    private Integer calorie;
    private Integer time;
}
