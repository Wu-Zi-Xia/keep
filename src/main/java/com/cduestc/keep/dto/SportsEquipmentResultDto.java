package com.cduestc.keep.dto;

import com.cduestc.keep.model.SportEquipment;
import lombok.Data;

import java.util.List;
@Data
public class SportsEquipmentResultDto {
    private List<SportEquipment> sportEquipmentList;
    private boolean isEnd;
}
