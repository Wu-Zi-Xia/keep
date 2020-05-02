package com.cduestc.keep.service;

import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.CoachQualificationExMapper;
import com.cduestc.keep.mapper.CoachQualificationMapper;
import com.cduestc.keep.model.CoachQualification;
import com.cduestc.keep.provider.SelectCoachParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachQualificationService {
    @Autowired
    private CoachQualificationExMapper coachQualificationExMapper;
    @Autowired
    private FriendService friendService;

    public void getCoach(long mysqlOffset, long mysqlSize,long userId) {
        //获取当前用户的所有关注的人
        List<Long> friendIdByUserId = friendService.getFriendIdByUserId(userId);
        //获得(没有被当前用户关注的)教练的总数,
        long coachNum = coachQualificationExMapper.selectCoachNum(friendIdByUserId);
        long l = coachNum - mysqlOffset;
        if(l<0){//代表请求已经超过
            throw new CustomizeException(CustomizeErrorCode.PRODUCT_IS_ENPTY);
        }
        if(l>0&&l<mysqlSize){
            mysqlSize=l;
        }
        SelectCoachParams selectCoachParams=new SelectCoachParams();
        selectCoachParams.setOffset(mysqlOffset);
        selectCoachParams.setSize(mysqlSize);
        selectCoachParams.setIds(friendIdByUserId);
        List<CoachQualification> coachQualifications = coachQualificationExMapper.selectCoachByLimit(selectCoachParams);
        return;
    }
}
