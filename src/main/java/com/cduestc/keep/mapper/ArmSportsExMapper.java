package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ArmSports;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArmSportsExMapper {
    int count();
    List<Long> selectIdByWeight(@Param("weight") Integer weight);
    List<ArmSports> selectByLimit(int offset,int size);
}
