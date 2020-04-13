package com.cduestc.keep.mapper;

import com.cduestc.keep.model.PlanProgress;
import org.apache.ibatis.annotations.Param;

public interface PlanProgressExMapper {
    int insert(PlanProgress record);

    Long selectPriKeyByOwnerID(@Param("ID") Long ID);
    Integer selectStateByOwnerId(@Param("ownerId") Long ownerId);

    Long selectCurrentStateByOwnerId(@Param("userId") Long userId);
}
