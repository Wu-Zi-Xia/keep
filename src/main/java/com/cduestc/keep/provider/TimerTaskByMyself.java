package com.cduestc.keep.provider;

import com.cduestc.keep.mapper.PlanProgressExMapper;
import com.cduestc.keep.mapper.PlanProgressMapper;
import com.cduestc.keep.model.PlanProgress;
import com.cduestc.keep.model.PlanProgressExample;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class TimerTaskByMyself {
    @Autowired

    public static void updatePlanCurrentState(HttpServletRequest request) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, day, 02, 00, 00);//设置执行时间
        Date defaultDate =calendar.getTime();
        if (defaultDate.before(new Date())) {
            // 将发送时间设为明天
            calendar.add(Calendar.DATE, 1);
            defaultDate = calendar.getTime();
        }
        java.util.Timer dTimer = new java.util.Timer();
        dTimer.schedule(new TimerTask() {
            @Autowired
            PlanProgressMapper planProgressMapper;
            @Autowired
            PlanProgressExMapper planProgressExMapper;
            @Override
            public void run() {

                List<PlanProgress> planProgresses = planProgressExMapper.selectAllCurrentState();
                Iterator<PlanProgress> iterator = planProgresses.iterator();

                while(iterator.hasNext()){
                    PlanProgress next = iterator.next();
                    next.setCurrentState(next.getCurrentState()+1l);
                    next.setState(null);
                    next.setEndPlanid(null);
                    next.setStartPlanid(null);
                    next.setOwnerId(null);
                    planProgressMapper.updateByPrimaryKeySelective(next);
                }

            }
        }, defaultDate , 24* 60* 60 * 1000);// 24* 60* 60 * 1000  24小时
    }

}
