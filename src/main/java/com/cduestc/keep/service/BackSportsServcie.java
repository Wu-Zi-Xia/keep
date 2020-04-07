package com.cduestc.keep.service;

import com.cduestc.keep.mapper.BackSportsExMapper;
import com.cduestc.keep.model.BackSports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackSportsServcie {
    @Autowired
    BackSportsExMapper backSportsExMapper;
    public List<BackSports> getSports(){
        List<BackSports> backSports = backSportsExMapper.selectByLimit(1, 10);
        return backSports;
    }
}
