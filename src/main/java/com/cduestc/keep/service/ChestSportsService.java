package com.cduestc.keep.service;

import com.cduestc.keep.mapper.ChestSportsExMapper;
import com.cduestc.keep.model.ChestSports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChestSportsService {
    @Autowired
    ChestSportsExMapper chestSportsExMapper;
    public List<ChestSports> getSports(){
        List<ChestSports> chestSports = chestSportsExMapper.selectByLimit(1, 10);
        return chestSports;
    }
}
