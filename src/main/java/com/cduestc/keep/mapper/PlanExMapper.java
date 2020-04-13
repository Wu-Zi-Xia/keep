package com.cduestc.keep.mapper;

import com.cduestc.keep.model.Plan;
import com.cduestc.keep.model.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanExMapper {
     long count();
     int insert(Plan plan);
     int selectStateByOwnerId(@Param("ownerId") Long ownerId);
}
