package com.cduestc.keep.mapper;

import com.cduestc.keep.dto.DeliverSimpleUserINFODTO;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.SearchUserParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserExMapper {
    int insert(User record);

    DeliverSimpleUserINFODTO selectSimpleUserINFOByID(long userId);

    List<String> selectAvatarURLByIDs(Set members);

    String selectAvatarURLByID(@Param("userId") Long userId);

    List<DeliverSimpleUserINFODTO> searchUser(SearchUserParams searchUserParams);
}
