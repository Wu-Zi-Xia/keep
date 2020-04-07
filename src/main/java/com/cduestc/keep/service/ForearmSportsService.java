package com.cduestc.keep.service;

import com.cduestc.keep.mapper.ForearmSportsExMapper;
import com.cduestc.keep.model.ForearmSports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForearmSportsService {
    @Autowired
    ForearmSportsExMapper forearmSportsExMapper;
    public List<ForearmSports> getSports(){
        List<ForearmSports> forearmSports = forearmSportsExMapper.selectByLimit(1, 10);
        return forearmSports;
    }
}
