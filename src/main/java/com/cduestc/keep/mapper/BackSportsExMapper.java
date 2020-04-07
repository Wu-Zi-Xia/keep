package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ArmSports;
import com.cduestc.keep.model.BackSports;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackSportsExMapper {
    public  int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
    List<BackSports> selectByLimit(int offset, int size);
}
