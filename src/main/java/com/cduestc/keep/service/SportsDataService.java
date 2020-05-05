package com.cduestc.keep.service;

import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.SportDataExMapper;
import com.cduestc.keep.mapper.SportsDataMapper;
import com.cduestc.keep.model.SportsData;
import com.cduestc.keep.model.SportsDataExample;
import com.cduestc.keep.provider.UpdateSportsDataParamer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsDataService {
    @Autowired
    private SportsDataMapper sportsDataMapper;
    @Autowired
    private SportDataExMapper sportDataExMapper;
    public void updateSportsDataByOwnerId(UpdateSportsDataParamer sportsData){
        //先判断里面有没有这个用户的运动数据
        SportsDataExample sportsDataExample=new SportsDataExample();
        sportsDataExample.createCriteria().andOwnerIdEqualTo(sportsData.getOwnerId());
        List<SportsData> sportsData1 =
                sportsDataMapper.selectByExample(sportsDataExample);
        if(sportsData1.size()==0){
            SportsData sportsData2=new SportsData();
            sportsData2.setOwnerId(sportsData.getOwnerId());
            sportsData2.setCalorie(sportsData.getCalorie());
            sportsData2.setSportsTime(sportsData.getSportsTime());
            sportsDataMapper.insert(sportsData2);
        }else{
            sportDataExMapper.updateSportsDataByOwnerId(sportsData);
        }
    }

    public SportsData getSportsData(Long userId) {
        SportsDataExample sportsDataExample=new SportsDataExample();
        sportsDataExample.createCriteria().andOwnerIdEqualTo(userId);
        List<SportsData> sportsData = sportsDataMapper.selectByExample(sportsDataExample);
        if(sportsData.size()==0){
         throw new CustomizeException(CustomizeErrorCode.SPORTS_DATA_IS_NOT_FOUND);
        }
        return sportsData.get(0);
    }
}
