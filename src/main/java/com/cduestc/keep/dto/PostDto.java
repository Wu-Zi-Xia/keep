package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class PostDto {
    private long ownerID;
    private String imageUrl;
    private String videoUrl;
    private String description;
    private String createDate;

}
