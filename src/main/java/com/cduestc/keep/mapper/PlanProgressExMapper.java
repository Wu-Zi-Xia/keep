package com.cduestc.keep.mapper;

import com.cduestc.keep.dto.UpdatePlanProgressDTO;
import com.cduestc.keep.model.Plan;
import com.cduestc.keep.model.PlanProgress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanProgressExMapper {
    int insert(PlanProgress record);

    Long selectPriKeyByOwnerID(@Param("ID") Long ID);
    Integer selectStateByOwnerId(@Param("ownerId") Long ownerId);

    Long selectCurrentStateByOwnerId(@Param("userId") Long userId);

    List<PlanProgress> selectAllCurrentState();

    void resetStatus(@Param("userId") Long userId);
    void updateState(UpdatePlanProgressDTO u);
}
