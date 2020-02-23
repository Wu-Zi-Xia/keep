package com.cduestc.keep.provider;

import com.cduestc.keep.mapper.PlanProgressMapper;
import com.cduestc.keep.model.PlanProgress;
import com.cduestc.keep.model.PlanProgressExample;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

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
            @Override
            public void run() {
                PlanProgress pp = (PlanProgress) request.getSession().getAttribute("PP");
                long currentState = pp.getCurrentState() + 1;
                pp.setCurrentState(currentState);
                PlanProgressExample planProgressExample=new PlanProgressExample();
                planProgressExample.createCriteria().andOwnerIdEqualTo(pp.getOwnerId());
                PlanProgress planProgress=new PlanProgress();
                planProgress.setCurrentState(currentState);
                planProgressMapper.updateByExampleSelective(planProgress,planProgressExample);
            }
        }, defaultDate , 24* 60* 60 * 1000);// 24* 60* 60 * 1000  24小时
    }

}
