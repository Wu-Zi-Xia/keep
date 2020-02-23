package com.cduestc.keep.service;

import com.cduestc.keep.dto.SportsEquipmentQueryDto;
import com.cduestc.keep.dto.SportsEquipmentResultDto;
import com.cduestc.keep.mapper.SportEquipmentMapper;
import com.cduestc.keep.mapper.SportExEquipmentMapper;
import com.cduestc.keep.model.SportEquipment;
import com.cduestc.keep.model.SportEquipmentExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportsEquipmentService {
    @Autowired
    SportEquipmentMapper sportEquipmentMapper;
    @Autowired
    SportExEquipmentMapper sportExEquipmentMapper;

    public SportsEquipmentResultDto getByTag(String type, int page, int size) {
        SportsEquipmentResultDto sportsEquipmentResultDto=new SportsEquipmentResultDto();
        int maxPage = 0;
        int offset=0;
        int totalCount=0;
        SportEquipmentExample equipmentExample=new SportEquipmentExample();

        if(type!=null){
            equipmentExample.createCriteria().andEquipmentTagEqualTo(type);
            totalCount=sportExEquipmentMapper.countByTag(type);
        }else {
            totalCount= sportExEquipmentMapper.countAll();
        }

        if(totalCount%size>0){
           maxPage = totalCount / size+1;
        }
        if(totalCount%size==0){
            maxPage=totalCount/size;
        }
        if(page<maxPage){
           offset =size*(page-1);
           sportsEquipmentResultDto.setEnd(false);
        }
        if(page==maxPage){
            offset=size*(page-1);
            sportsEquipmentResultDto.setEnd(true);
        }
        equipmentExample.setOffset(offset);
        equipmentExample.setLimit(size);
        List<SportEquipment> sportEquipments = sportEquipmentMapper.selectByExample(equipmentExample);
        sportsEquipmentResultDto.setSportEquipmentList(sportEquipments);
        return sportsEquipmentResultDto;
    }

    public List<SportEquipment> selectBySearch(int offset, int limit, String type, String search) {
        String[] tags = StringUtils.split(search, " ");
        search= Arrays.stream(tags).collect(Collectors.joining("|"));
        SportsEquipmentQueryDto sportsEquipmentQueryDto=new SportsEquipmentQueryDto();
        sportsEquipmentQueryDto.setLimit(limit);
        sportsEquipmentQueryDto.setOffset(offset);
        sportsEquipmentQueryDto.setSearch(search);
        sportsEquipmentQueryDto.setType(type);
        List<SportEquipment> sportEquipments = sportExEquipmentMapper.selectBySearch(sportsEquipmentQueryDto);
        return sportEquipments;
    }

    public SportEquipment getByID(long id) {
        SportEquipment sportEquipment = sportEquipmentMapper.selectByPrimaryKey(id);
        return sportEquipment;
    }

    public SportsEquipmentResultDto getSomethingByID(Long id) {
        SportsEquipmentResultDto sportsEquipmentResultDto = sportExEquipmentMapper.selectSomethingByID(id);
        return sportsEquipmentResultDto;
    }
}

