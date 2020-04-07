package com.cduestc.keep.service;

import com.cduestc.keep.mapper.ShankSportsExMapper;
import com.cduestc.keep.model.ShankSports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShankSportsService {
    @Autowired
    ShankSportsExMapper shankSportsExMapper;
    public List<ShankSports> getSports(){
        List<ShankSports> shankSports = shankSportsExMapper.selectByLimit(1, 10);
        return shankSports;
    }
}
