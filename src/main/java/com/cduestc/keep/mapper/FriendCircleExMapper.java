package com.cduestc.keep.mapper;

import com.cduestc.keep.model.FriendCircle;
import com.cduestc.keep.model.Post;
import com.cduestc.keep.provider.PostSelectParameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface FriendCircleExMapper {
    void insert(FriendCircle friendCircle);
    List<Long> selectByLimit(@Param("parameter") PostSelectParameter postSelectParameter);

    int countByOwnerId(@Param("id") long id,@Param("isOwn") int isOwn);
    void insertFriCirS(@Param("friendCircleList") List<FriendCircle> friendCircles);
}
