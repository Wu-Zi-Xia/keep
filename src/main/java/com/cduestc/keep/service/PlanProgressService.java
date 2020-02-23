package com.cduestc.keep.service;

import com.cduestc.keep.model.PlanProgress;
import com.cduestc.keep.mapper.PlanProgressMapper;
import com.cduestc.keep.model.PlanProgressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanProgressService {
    @Autowired
    PlanProgressMapper planProgressMapper;
    //创建一个计划的进程记录
    public int createProgress(PlanProgress planProgress){
        int insert = planProgressMapper.insert(planProgress);
        return insert;
    }
    //修改一个计划的进程的当前状态
    public int updatePlanProgressCurrentStateByOwner(long ownerID,long currentState){
        PlanProgressExample planProgressExample=new PlanProgressExample();
        planProgressExample.createCriteria().andOwnerIdEqualTo(ownerID);
        PlanProgress planProgress=new PlanProgress();
        planProgress.setCurrentState(currentState);
        int i = planProgressMapper.updateByExampleSelective(planProgress, planProgressExample);
        return i;
    }


}
