package com.cduestc.keep.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryExMapper {
    List<Long> selectProductIdByCategoryId(@Param("categoryId") Long categoryId);
}
