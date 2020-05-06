package com.cduestc.keep.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface ProductCategoryExMapper {
    List<Long> selectProductIdByCategoryId(@Param("categoryId") Long categoryId);
    List<Long> selectProductIdByCategoryIds(List<Long> ids);
    long  selectParentIdByid(@Value("productId") Long productId);
    List<Long>  selectParentIdsByIds(@Value("productIds") List<Long> productIds);
    int countByParentId(@Value("ids") List<Long> ids);
}
