package com.cduestc.keep.provider;

import lombok.Data;

@Data
public class PostSelectParameter {
    private Long ownerId;
    private int offset;
    private int size;
    private String order;
    private int isOwn;
    private int likeCount;
}
