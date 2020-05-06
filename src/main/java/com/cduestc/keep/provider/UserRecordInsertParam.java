package com.cduestc.keep.provider;

import lombok.Data;

import java.util.List;

@Data
public class UserRecordInsertParam {
    private List<Long> productIds;
    private Long ownerId;
}
