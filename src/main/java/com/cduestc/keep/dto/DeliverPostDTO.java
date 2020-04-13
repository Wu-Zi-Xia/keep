package com.cduestc.keep.dto;

import com.cduestc.keep.model.Comment;
import com.cduestc.keep.model.Post;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data//每一条数据的格式必须是这个样子的
public class DeliverPostDTO implements Serializable {
    private DeliverUserINFODTO deliverUserINFODTO;
    private Post post;
    private List<DeliverCommentDto> comments;//一级评论里面还有二级评论的list
    private boolean isEnd;
}
