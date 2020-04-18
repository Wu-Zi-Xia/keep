package com.cduestc.keep.dto;

import com.cduestc.keep.model.User;
import lombok.Data;

@Data
public class DeliverUserINFODto {
    private User user;
    private long focus;
    private long fans;
}
