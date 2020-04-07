package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class AchieveCommentDTO {
    private long reviewerID;
    private int type;
    private String content;
    private long ownerID;
}
