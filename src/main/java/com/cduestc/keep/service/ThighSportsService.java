package com.cduestc.keep.service;

import com.cduestc.keep.mapper.ThighSportsExMapper;
import com.cduestc.keep.model.ThighSports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThighSportsService {
    @Autowired
    ThighSportsExMapper thighSportsExMapper;
    public List<ThighSports> getSports(){
        List<ThighSports> thighSports = thighSportsExMapper.selectByLimit(1, 10);
        return thighSports;
    }
}
