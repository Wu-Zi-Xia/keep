package com.cduestc.keep.dto;

import lombok.Data;

@Data
public class AchieveCommentDTO {
    //评论的类型（给动态做评论，给评论做评论）
    private String type;
    //评论的内容
    private String content;
    //被评论的动态或者评论
    private Long ownerID;
    //被评论的动态或者评论的拥有者
    private Long toUserID;
}
