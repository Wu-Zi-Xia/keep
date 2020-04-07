package com.cduestc.keep.service;

import com.cduestc.keep.mapper.BellySportsExMapper;
import com.cduestc.keep.mapper.BellySportsMapper;
import com.cduestc.keep.model.BellySports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BellySportsService {
    @Autowired
    BellySportsExMapper bellyExSportsMapper;

    public List<BellySports> getBellySports() {
        List<BellySports> bellySports = bellyExSportsMapper.selectByLimit(0,10);
        return bellySports;
    }
}
