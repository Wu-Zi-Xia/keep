package com.cduestc.keep.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArmSportsExMapper {
    public int count();
    List<Integer> selectIdByWeight(@Param("weight") int weight);
}
