package com.cduestc.keep.service;

import com.cduestc.keep.mapper.ArmSportsExMapper;
import com.cduestc.keep.model.ArmSports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmSportsService {
    @Autowired
    ArmSportsExMapper armSportsExMapper;
    public List<ArmSports> getSports(){
        List<ArmSports> armSports = armSportsExMapper.selectByLimit(1, 10);
        return armSports;
    }
}
