package com.cduestc.keep.mapper;

import com.cduestc.keep.model.CoachQualification;
import com.cduestc.keep.provider.SelectCoachParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoachQualificationExMapper {
    long selectCoachNum(@Param("ids") List<Long> ids);

    List<CoachQualification> selectCoachByLimit(SelectCoachParams selectCoachParams);
}
