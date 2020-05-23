package com.cduestc.keep.mapper;

import com.cduestc.keep.dto.DeliverSimpleUserINFODTO;
import com.cduestc.keep.model.Friend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendExMapper {
 int insert(Friend friend);
 int countByOwner(@Param("ownerId") Long ownerId);

    List<Long> getFriendIdByUserId(@Param("userId") Long userId);

    List<DeliverSimpleUserINFODTO> getFans(@Param("userId") Long userId);

    List<DeliverSimpleUserINFODTO> getFocus(@Param("userId") Long userId);
}
