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
    @Autowired
    CoachQualificationMapper coachQualificationMapper;

    public  List<CoachQualification> getCoach(long mysqlOffset, long mysqlSize) {


        long coachNum = coachQualificationExMapper.selectCoachNum();
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
        List<CoachQualification> coachQualifications = coachQualificationExMapper.selectCoachByLimit(selectCoachParams);
        return coachQualifications;
    }
}
