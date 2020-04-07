package com.cduestc.keep.dto;

import com.cduestc.keep.model.Comment;
import lombok.Data;

import java.util.List;

@Data
public class DeliverCommentDto {
    private Comment comment;//一级评论
    private List<Comment> commentList;//一级评论的二级评论
}
