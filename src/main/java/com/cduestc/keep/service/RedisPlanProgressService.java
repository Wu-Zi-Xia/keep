package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.mapper.PlanProgressExMapper;
import com.cduestc.keep.mapper.PlanProgressMapper;
import com.cduestc.keep.model.PlanProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class RedisPlanProgressService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    PlanProgressExMapper planProgressExMapper;
    //插入到redis中
    public  void insert(String name, PlanProgress planProgress){
        planProgress.setPlanProgressid(null);
        JSON o = (JSON) JSONObject.toJSON(planProgress);
        Map PPMap= JSONObject.parseObject(o.toString());
        redisTemplate.opsForHash().putAll(name,PPMap);
    }
    //判断是否是当前状态
    public Integer isCurrent(Long ID) {
        Long PPID= planProgressExMapper.selectPriKeyByOwnerID(ID);
        Integer currentState =(Integer) redisTemplate.opsForHash().get("user:" + ID + ":PP:" + PPID, "currentState");
        return currentState;
    }
}
