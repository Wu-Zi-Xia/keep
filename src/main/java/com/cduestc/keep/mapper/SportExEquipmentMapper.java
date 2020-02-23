package com.cduestc.keep.mapper;

import com.cduestc.keep.dto.SportsEquipmentQueryDto;
import com.cduestc.keep.dto.SportsEquipmentResultDto;
import com.cduestc.keep.model.SportEquipment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportExEquipmentMapper {
    List<SportEquipment> selectBySearch(SportsEquipmentQueryDto questionQueryDto);
    int countAll();

    int countByTag(@Param("type") String type);

    SportsEquipmentResultDto selectSomethingByID(@Param("id")Long id);
}
