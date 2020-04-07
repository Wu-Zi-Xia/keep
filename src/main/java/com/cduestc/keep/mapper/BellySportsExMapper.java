package com.cduestc.keep.mapper;

import com.cduestc.keep.model.BellySports;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BellySportsExMapper {
     int count();
    List<Integer> selectIdByWeight(@Param("record") int weight);
    List<BellySports> selectByLimit(int offset,int size);
}
