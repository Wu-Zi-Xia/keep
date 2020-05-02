package com.cduestc.keep.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeliverZanDto {
    private List<String> avatarURLs;
    private boolean isZan;
}
