package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class AchieveSportsHistoryDto {
    //计划或者是运动的id
    private Long sportsId;
    //区别计划或者运动的标志位R(跑步),S（计划），L（课程）
    private String type;
    private int calorie;
    //运动时间
    private Integer sportsTime;
}
