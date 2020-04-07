package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ForearmSports;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForearmSportsExMapper {
    public int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
    List<ForearmSports> selectByLimit(int offset, int size);
}
