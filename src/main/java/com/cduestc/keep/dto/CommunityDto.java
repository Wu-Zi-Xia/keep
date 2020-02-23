package com.cduestc.keep.dto;

import com.cduestc.keep.model.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommunityDto {
    //用户信息
    private String avatarUrl;
    private String nickname;
    //动态的信息
    private String imageUrl;
    private String videoUrl;
    private String description;
    //评论的内容
   private List<Comment> comment;
}
