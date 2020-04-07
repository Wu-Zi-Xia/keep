package com.cduestc.keep.mapper;

import com.cduestc.keep.dto.DeliverUserINFODTO;
import com.cduestc.keep.model.User;

public interface UserExMapper {
    int insert(User record);

    DeliverUserINFODTO selectSimpleUserINFOByID(long userId);
}
