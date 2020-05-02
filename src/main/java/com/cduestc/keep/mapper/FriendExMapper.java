package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Friend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendExMapper {
 int insert(Friend friend);
 int countByOwner(@Param("ownerId") Long ownerId);

    List<Long> getFriendIdByUserId(@Param("userId") long userId);
}
