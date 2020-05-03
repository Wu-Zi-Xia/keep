package com.cduestc.keep.dto;

import com.cduestc.keep.model.Post;
import lombok.Data;

@Data
public class DeliverRecomendDto {
    //教练获取的资质认证
    private String cerString;
    private DeliverSimpleUserINFODTO deliverSimpleUserINFODTO;
    private Post post;
}
