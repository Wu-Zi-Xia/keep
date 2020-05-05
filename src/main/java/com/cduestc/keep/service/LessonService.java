package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.DeliverKeepLesson;
import com.cduestc.keep.mapper.ChooseLessonMapper;
import com.cduestc.keep.mapper.KeepLessonExMapper;
import com.cduestc.keep.mapper.KeepLessonMapper;
import com.cduestc.keep.model.ChooseLesson;
import com.cduestc.keep.model.KeepLesson;
import com.cduestc.keep.model.KeepLessonExample;
import com.cduestc.keep.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class LessonService {
    @Autowired
    KeepLessonExMapper keepLessonExMapper;
    @Autowired
    ChooseLessonMapper chooseLessonMapper;
    @Autowired
    KeepLessonMapper keepLessonMapper;
    @Value("${redis.keep.lessonTable}")
    String redisLessonTable;
    @Value("${redis.keep.lessonTableSort}")
    String redisLessonTableSort;
    @Value("${redis.keep.lessonTableSortH}")
    String redisLessonTableSortH;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    PlanService planService;
    public void getHotLesson() {
        //实即获取的是所有的lesson
        List<KeepLesson> allLessons = keepLessonExMapper.getHotLesson();
        //
        // 将所有的数据都异步的同步到redis中
        Iterator<KeepLesson> iterator = allLessons.iterator();
         int i=0;
        while (iterator.hasNext()){
            i++;
            KeepLesson next = iterator.next();
            DeliverKeepLesson deliverKeepLesson=new DeliverKeepLesson();
            BeanUtils.copyProperties(next,deliverKeepLesson);
            //deliverKeepLesson.setSports(planService.getSportsURLS(next.getSports()));
            //将拥有真正的运动的list放入到redis中
            JSON jsons = (JSON) JSON.toJSON(deliverKeepLesson);
            Map paramMap = (Map) JSONObject.parseObject(jsons.toString());
            //将具体的课程信息放入到redis中
            redisTemplate.opsForHash().putAll(redisLessonTable+next.getId().toString(),paramMap);
             if(i<=4){
            //将键值放入到热门的Zsort中
            redisTemplate.opsForZSet().
                    add(redisLessonTableSortH,redisLessonTable+next.getId().toString(),next.getHot());
             }
             else{
                 //将键值放入到非热门的Zsort中
                 redisTemplate.opsForZSet().
                         add(redisLessonTableSort,redisLessonTable+next.getId().toString(),next.getHot());
             }
        }
    }

    public void addLesson(User user,Long id) {
        //往chooseLesson中加入一条记录
        ChooseLesson chooseLesson=new ChooseLesson();
        chooseLesson.setLessonId(id);
        chooseLesson.setOwnerId(user.getUserId());
        chooseLessonMapper.insert(chooseLesson);
        //异步的去修改keepLesson里面的hot值
        keepLessonExMapper.updateHot(id,1);
    }

    public long selectLessonByID(Long id) {
        KeepLessonExample keepLessonExample=new KeepLessonExample();
        keepLessonExample.createCriteria().andIdEqualTo(id);
        long l = keepLessonMapper.countByExample(keepLessonExample);
        return l;
    }
}
