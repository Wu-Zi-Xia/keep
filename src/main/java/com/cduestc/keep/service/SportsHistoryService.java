package com.cduestc.keep.service;

import com.cduestc.keep.dto.AchieveSportsHistoryDto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.KeepLessonMapper;
import com.cduestc.keep.mapper.PlanMapper;
import com.cduestc.keep.mapper.SportsHistoryMapper;
import com.cduestc.keep.model.*;
import com.cduestc.keep.provider.UpdateSportsDataParamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsHistoryService {
    @Autowired
    SportsHistoryMapper sportsHistoryMapper;
    @Autowired
    SportsDataService sportsDataService;
    @Autowired
    PlanMapper planMapper;
    @Autowired
    KeepLessonMapper keepLessonMapper;
    public void insertSportsHistory(AchieveSportsHistoryDto achieveSportsHistoryDto,
                                    User user){
        //先从数据库去查找运动的资源
        switch (achieveSportsHistoryDto.getType()){
            case "S":
                Plan plan = planMapper.selectByPrimaryKey(achieveSportsHistoryDto.getSportsId());
                if(plan==null){
                    throw new CustomizeException(CustomizeErrorCode.RESOURCE_NOT_FOUND);
                }
                break;
            case "L":
                KeepLesson keepLesson = keepLessonMapper.selectByPrimaryKey(achieveSportsHistoryDto.getSportsId());
                if(keepLesson==null){
                    throw new CustomizeException(CustomizeErrorCode.RESOURCE_NOT_FOUND);
                }
                break;
        }
        SportsHistory sportsHistory=new SportsHistory();
        sportsHistory.setFinishDate(System.currentTimeMillis());
        sportsHistory.setOwnerId(user.getUserId());
        sportsHistory.setType(achieveSportsHistoryDto.getType());
        sportsHistory.setSportsId(achieveSportsHistoryDto.getSportsId());
        sportsHistory.setCalorie(achieveSportsHistoryDto.getCalorie());
        sportsHistory.setSportsTime(achieveSportsHistoryDto.getSportsTime());
        //插入运动历史记录表
        sportsHistoryMapper.insert(sportsHistory);
        //可以异步去做插入到运动数据表
        UpdateSportsDataParamer sportsData=new UpdateSportsDataParamer();
        sportsData.setOwnerId(user.getUserId());
        sportsData.setCalorie(achieveSportsHistoryDto.getCalorie());
        sportsData.setSportsTime(achieveSportsHistoryDto.getSportsTime());
        sportsDataService.updateSportsDataByOwnerId(sportsData);
    }

    public List<SportsHistory> getSportsHistoryById(Long userId) {
        SportsHistoryExample sportsHistoryExample=new SportsHistoryExample();
        sportsHistoryExample.createCriteria().andOwnerIdEqualTo(userId);
        List<SportsHistory> sportsHistories = sportsHistoryMapper.selectByExample(sportsHistoryExample);
        if(sportsHistories.size()==0){
            throw new CustomizeException(CustomizeErrorCode.SPORTS_DATA_IS_NOT_FOUND);
        }
        return sportsHistories;
    }
}
