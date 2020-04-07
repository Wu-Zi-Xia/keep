package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ShankSports;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShankSportsExMapper {
    public int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
    List<ShankSports> selectByLimit(int offset, int size);
}
