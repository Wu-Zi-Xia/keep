package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ArmSports;
import com.cduestc.keep.model.ChestSports;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChestSportsExMapper {
    public int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
    List<ChestSports> selectByLimit(int offset, int size);
}
