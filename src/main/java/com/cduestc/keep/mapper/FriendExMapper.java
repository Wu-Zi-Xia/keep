package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Friend;
import org.apache.ibatis.annotations.Param;

public interface FriendExMapper {
 int insert(Friend friend);
 int countByOwner(@Param("ownerId") Long ownerId);
}
