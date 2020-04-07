package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.DeliverPlanDTO;
import com.cduestc.keep.model.Plan;
import com.cduestc.keep.model.Post;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.Sports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class RedisPlanService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    RedisPlanProgressService redisPlanProgressService;
    @Autowired
    DefaultRedisScript<List> defaultRedisScript;
    //插入到redis中
    public  void insert(String tableName, Plan plan){
        //将计划信息放入到redis中
        JSON o = (JSON) JSON.toJSON(plan);
        Map planMap= JSONObject.parseObject(o.toString());
        redisTemplate.opsForHash().putAll(tableName,planMap);
    }

    public List<DeliverPlanDTO> getPlan(String redisTableName, User user) {
        List<DeliverPlanDTO> deliverPlanDTOS=new ArrayList<>();
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luaScript/select2.lua")));
        List mysqlKeys =(List) redisTemplate.execute(defaultRedisScript,Collections.singletonList(redisTableName),"null");
        //System.out.println(mysqlKeys);
        Iterator iterator = mysqlKeys.iterator();
        while (iterator.hasNext()){
            DeliverPlanDTO deliverPlanDTO=new DeliverPlanDTO();
            Long mysqlID =(Long)iterator.next();
            Map entries = redisTemplate.opsForHash().entries("user:" + user.getUserId() + ":plan:" + mysqlID);
            //deliverPlanDTO.setOwnerID(entries.get("ownerId"));
            deliverPlanDTO.setState((Integer)entries.get("state"));
            Long planId = mysqlID;
            deliverPlanDTO.setPlanId(planId);//设置ID
            List<Sports> sports = getSportsURLS((String) entries.get("sports"));
            deliverPlanDTO.setSports(sports);
            Long currentID = Long.valueOf(redisPlanProgressService.isCurrent(user.getUserId()));

            if(planId.equals(currentID)){//判断是否是当天的运动
            deliverPlanDTO.setCurrent(true);
            }
            deliverPlanDTOS.add(deliverPlanDTO);
        }
          return deliverPlanDTOS;

    }
    //A：大臂，F：小臂，C：胸部，B：背部，E：腹部，T：大腿，S：小腿

    //辅助方法,获取运动的地址
    private List<Sports> getSportsURLS(String sportsString){
        List<Sports> sportsList=new ArrayList<>();
        String[] arr = sportsString.split(","); // 用,分割
        Map a;
        Sports sports;
        JSON o;
        String sportsID;
        for(int i=0;i<arr.length;i++){
            char c = arr[i].charAt(0);
            switch (c){
                case 'A':
                    sportsID=arr[i].substring(1);
                   a=redisTemplate.opsForHash().entries("armSport:"+sportsID);
                     o= (JSON) JSON.toJSON(a);
                    sports = JSONObject.toJavaObject(o, Sports.class);
                    sports.setSportsId(Long.parseLong(sportsID));
                    sportsList.add(sports);
                    break;
                case 'F':
                    sportsID= arr[i].substring(1);
                    a=redisTemplate.opsForHash().entries("forearmSport:"+ sportsID);
                    o = (JSON) JSON.toJSON(a);
                    sports = JSONObject.toJavaObject(o, Sports.class);
                    sports.setSportsId(Long.parseLong(sportsID));
                    sportsList.add(sports);
                    break;
                case 'C':
                    sportsID=arr[i].substring(1);
                    a=redisTemplate.opsForHash().entries("chestSport:"+sportsID);
                    o = (JSON) JSON.toJSON(a);
                    sports = JSONObject.toJavaObject(o, Sports.class);
                    sports.setSportsId(Long.parseLong(sportsID));
                    sportsList.add(sports);
                    break;
                case 'B':
                    sportsID=arr[i].substring(1);
                    a=redisTemplate.opsForHash().entries("backSport:"+sportsID);
                    o = (JSON) JSON.toJSON(a);
                    sports = JSONObject.toJavaObject(o, Sports.class);
                    sports.setSportsId(Long.parseLong(sportsID));
                    sportsList.add(sports);
                    break;
                case 'E':
                    sportsID=arr[i].substring(1);
                    a=redisTemplate.opsForHash().entries("bellySport:"+sportsID);
                    o = (JSON) JSON.toJSON(a);
                    sports = JSONObject.toJavaObject(o, Sports.class);
                    sports.setSportsId(Long.parseLong(sportsID));
                    sportsList.add(sports);
                    break;
                case 'T':
                    sportsID=arr[i].substring(1);
                    a=redisTemplate.opsForHash().entries("thighSport:"+sportsID);
                    o = (JSON) JSON.toJSON(a);
                    sports = JSONObject.toJavaObject(o, Sports.class);
                    sports.setSportsId(Long.parseLong(sportsID));
                    sportsList.add(sports);
                    break;
                case 'S':
                    sportsID=arr[i].substring(1);
                    a=redisTemplate.opsForHash().entries("shankSport:"+sportsID);
                    o = (JSON) JSON.toJSON(a);
                    sports = JSONObject.toJavaObject(o, Sports.class);
                    sports.setSportsId(Long.parseLong(sportsID));
                    sportsList.add(sports);
                    break;
            }
        }
        return sportsList;
    }
}
