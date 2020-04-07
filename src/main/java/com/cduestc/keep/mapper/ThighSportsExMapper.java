package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ThighSports;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThighSportsExMapper {
    public int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
    List<ThighSports> selectByLimit(int offset, int size);
}
