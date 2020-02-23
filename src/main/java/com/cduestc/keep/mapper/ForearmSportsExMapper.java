package com.cduestc.keep.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForearmSportsExMapper {
    public int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
}
