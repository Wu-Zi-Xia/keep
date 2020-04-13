package com.cduestc.keep.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class PostDto {
    private long ownerId;
    private String imageUrl;
    private String videoUrl;
    private String description;
    private Long createDate;
    private Integer likeCount;
    private Integer commentCount;
}
