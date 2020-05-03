package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Post;
import com.cduestc.keep.provider.PostSelectParameter;
import com.cduestc.keep.provider.UpdatePostParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostExMapper {
    int insert(Post post);
    List<Post> selectByLimit(PostSelectParameter postSelectParamerter);

    int countByOwnerId(@Param("id") long id);

    void updateLikeCount(@Param("record")UpdatePostParam updatePostParam);

    Long selectOwnerIdByKey(@Param("postId") Long postId);

    void updatePostCommentCount(@Param("record") UpdatePostParam updatePostParam);

    int countByLikeCount(@Param("likeCount") int likeCount);

    List<Post> selectByLikeCount(PostSelectParameter postSelectParameter);
}
