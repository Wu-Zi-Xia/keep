package com.cduestc.keep.mapper;

import org.apache.ibatis.annotations.Param;

public interface CommentExMapper {
    Long selectOwnerIdByKey(@Param("commentId") Long commentId);
}
