package com.cduestc.keep.service;

import com.cduestc.keep.dto.AchieveSportsHistoryDto;
import com.cduestc.keep.mapper.SportsHistoryMapper;
import com.cduestc.keep.model.SportsHistory;
import com.cduestc.keep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsHistoryService {
    @Autowired
    SportsHistoryMapper sportsHistoryMapper;

    public void insertSportsHistory(AchieveSportsHistoryDto achieveSportsHistoryDto,
                                    User user){

        SportsHistory sportsHistory=new SportsHistory();
        sportsHistory.setFinishDate(System.currentTimeMillis());
        sportsHistory.setOwnerId(user.getUserId());
        sportsHistory.setType(achieveSportsHistoryDto.getType());
        sportsHistory.setSportsId(achieveSportsHistoryDto.getSportsId());
        sportsHistoryMapper.insert(sportsHistory);
    }
}
