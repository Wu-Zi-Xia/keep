package com.cduestc.keep.mapper;

import com.cduestc.keep.dto.DeliverUserINFODTO;
import com.cduestc.keep.model.User;

import java.util.List;
import java.util.Set;

public interface UserExMapper {
    int insert(User record);

    DeliverUserINFODTO selectSimpleUserINFOByID(long userId);

    List<String> selectAvatarURLByIDs(Set members);
}
