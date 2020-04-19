package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.DeliverPostDTO;
import com.cduestc.keep.mapper.ChooseLessonMapper;
import com.cduestc.keep.mapper.KeepLessonMapper;
import com.cduestc.keep.model.ChooseLesson;
import com.cduestc.keep.model.ChooseLessonExample;
import com.cduestc.keep.model.KeepLesson;
import com.cduestc.keep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChooseLessonService {
    @Autowired
    ChooseLessonMapper chooseLessonMapper;
    @Autowired
    KeepLessonMapper keepLessonMapper;
    @Value("${redis.keep.myLesson}")
    String redisMyLessonSort;
    @Autowired
    RedisTemplate redisTemplate;
    @Value("${redis.keep.lessonTable}")
    String redisLessonTable;
    @Value("${redis.keep.lessonTableSort}")
    String redisLessonTableSort;
    @Autowired
    LessonService lessonService;
    public List<KeepLesson> getLessonByOwnerId(User user){
        //查询是否有我的添加课程记录
        ChooseLessonExample chooseLessonExample=new ChooseLessonExample();
        chooseLessonExample.createCriteria().andOwnerIdEqualTo(user.getUserId());
        List<ChooseLesson> chooseLessons = chooseLessonMapper.selectByExample(chooseLessonExample);
        if(chooseLessons==null||chooseLessons.size()==0){
            return null;
        }
        List<KeepLesson> lessons= new ArrayList<>();
        if(redisTemplate.hasKey(redisMyLessonSort+user.getUserId().toString())){
            if(redisTemplate.hasKey(redisLessonTableSort)){
                Set range = redisTemplate.opsForZSet().range(redisMyLessonSort + user.getUserId().toString(), 0, -1);
                Iterator iterator = range.iterator();
                while(iterator.hasNext()){
                    String next =(String) iterator.next();
                    Map entries = redisTemplate.opsForHash().entries(next);
                    Object o = JSONObject.toJSON(entries);
                    KeepLesson keepLesson=JSONObject.toJavaObject((JSON) o, KeepLesson.class);
                    keepLesson.setSports(null);
                    lessons.add(keepLesson);
                }
                return lessons;
            }
            else{
                //执行将课程放入redis中
                lessonService.getHotLesson();
                Set range = redisTemplate.opsForZSet().range(redisMyLessonSort + user.getUserId().toString(), 0, -1);
                Iterator iterator = range.iterator();
                while(iterator.hasNext()){
                    String next =(String) iterator.next();
                    Map entries = redisTemplate.opsForHash().entries(next);
                    Object o = JSONObject.toJSON(entries);
                    KeepLesson keepLesson=JSONObject.toJavaObject((JSON) o, KeepLesson.class);
                    keepLesson.setSports(null);
                    lessons.add(keepLesson);
                }
                return lessons;
            }
        }
        else{//redis中没有我的lesson的集合
            Iterator<ChooseLesson> iterator = chooseLessons.iterator();
            while(iterator.hasNext()){
                ChooseLesson next = iterator.next();
                redisTemplate.opsForZSet().add(
                        redisMyLessonSort+user.getUserId().toString(),
                        redisLessonTable+next.getLessonId().toString(),
                        0);
            }
            if(redisTemplate.hasKey(redisLessonTableSort)){
                Set range = redisTemplate.opsForZSet().range(redisMyLessonSort + user.getUserId().toString(), 0, -1);
                Iterator iterator2 = range.iterator();
                while(iterator2.hasNext()){
                    String next =(String) iterator2.next();
                    Map entries = redisTemplate.opsForHash().entries(next);
                    Object o = JSONObject.toJSON(entries);
                    KeepLesson keepLesson=JSONObject.toJavaObject((JSON) o, KeepLesson.class);
                    keepLesson.setSports(null);
                    lessons.add(keepLesson);
                }
                return lessons;
            }
            else{
                //执行将课程放入redis中
                lessonService.getHotLesson();
                Set range = redisTemplate.opsForZSet().range(redisMyLessonSort + user.getUserId().toString(), 0, -1);
                Iterator iterator3 = range.iterator();
                while(iterator3.hasNext()){
                    String next =(String) iterator3.next();
                    Map entries = redisTemplate.opsForHash().entries(next);
                    Object o = JSONObject.toJSON(entries);
                    KeepLesson keepLesson=JSONObject.toJavaObject((JSON) o, KeepLesson.class);
                    keepLesson.setSports(null);
                    lessons.add(keepLesson);
                }
                return lessons;
            }

        }
    }

    public long countByIdAndOwnerId(Long id,Long ownerId) {
        ChooseLessonExample chooseLessonExample=new ChooseLessonExample();
        ChooseLessonExample.Criteria criteria = chooseLessonExample.createCriteria();
        criteria.andOwnerIdEqualTo(ownerId);
        criteria.andLessonIdEqualTo(id);
        long l = chooseLessonMapper.countByExample(chooseLessonExample);
        return l;

    }
}
