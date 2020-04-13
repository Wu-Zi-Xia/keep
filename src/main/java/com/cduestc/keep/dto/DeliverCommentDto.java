package com.cduestc.keep.dto;

import com.cduestc.keep.model.Comment;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeliverCommentDto implements Serializable {
    private Comment comment;//一级评论
    private List<Comment> commentList;//一级评论的二级评论
}
