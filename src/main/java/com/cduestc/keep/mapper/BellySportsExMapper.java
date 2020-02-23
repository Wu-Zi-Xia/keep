package com.cduestc.keep.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BellySportsExMapper {
    public int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
}
