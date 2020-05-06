package com.cduestc.keep.dto;

import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
public class DeliverAnathorPostDto {
    private Long postId;
    private Long ownerId;
    private String[] imageUrl;
    private String[] videoUrl;
    private Long createDate;
    private String description;
    private Integer likeCount;
    private Integer commentCount;
}
