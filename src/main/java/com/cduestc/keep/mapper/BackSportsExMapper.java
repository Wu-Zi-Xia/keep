package com.cduestc.keep.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackSportsExMapper {
    public  int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
}
