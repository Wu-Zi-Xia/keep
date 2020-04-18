package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.cduestc.keep.dto.DeliverKeepLesson;
import com.cduestc.keep.model.KeepLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Service
public class RedisLessonService {
    @Value("${redis.keep.lessonTable}")
    String redisLessonTable;
    @Value("${redis.keep.lessonTableSort}")
    String redisLessonTableSort;
    @Value("${redis.keep.lessonTableSortH}")
    String redisLessonTableSortH;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    LessonService lessonService;
    @Value("${domin}")
    String domin;
    public List<KeepLesson> getHotLesson( HttpServletResponse response) throws IOException {
        if(!redisTemplate.hasKey(redisLessonTableSortH)){//如果redis中不存在，就去mysql里面去查询

            //放入到redis中
            lessonService.getHotLesson();
            //重定向到个接口
            response.sendRedirect(domin+"getHotLesson");
        }
        //反向获取hot数最多的四个
        Set range = redisTemplate.opsForZSet().reverseRange(redisLessonTableSortH, 0, 3);//获取前四个就是最火的课程
        Iterator iterator = range.iterator();
        List<KeepLesson> lessons=new ArrayList<>();
        while(iterator.hasNext()){
            String next = (String) iterator.next();
            Map entries = redisTemplate.opsForHash().entries(next);
            Object o = JSON.toJSON(entries);
            KeepLesson keepLesson = JSON.toJavaObject((JSON) o, KeepLesson.class);
            keepLesson.setSports(null);
            keepLesson.setHot(null);
            keepLesson.setType(null);
            lessons.add(keepLesson);
        }
        return lessons;
    }

    public List<KeepLesson> getSystemLesson(HttpServletResponse response,String more) throws IOException {
        //判断redis中是否存在，不存在就同步到redis中
        if(!redisTemplate.hasKey(redisLessonTableSort)){
            //放入到redis中
            lessonService.getHotLesson();
            //重定向到个接口
            if(more!=null){
                response.sendRedirect(domin+"getSystemLesson?more="+more);
                return null;
            }
            else{
                response.sendRedirect(domin+"getSystemLesson");
                return null;
            }

        }
        List<KeepLesson> keepLessons=new ArrayList<>();
        Set set=null;
        if(more!=null){
            set = redisTemplate.opsForZSet().reverseRange(redisLessonTableSort, 0, -1);
        }
        else{
            set = redisTemplate.opsForZSet().reverseRange(redisLessonTableSort, 0, 2);
        }
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            Map entries = redisTemplate.opsForHash().entries(next);

            Object o = JSON.toJSON(entries);
            KeepLesson keepLesson = JSON.toJavaObject((JSON) o, KeepLesson.class);
            keepLesson.setSports(null);
            keepLessons.add(keepLesson);
        }
        return keepLessons;
    }

    public DeliverKeepLesson getLessonById(Long id) {
        Map entries = redisTemplate.opsForHash().entries(redisLessonTable + id.toString());
        Object o = JSON.toJSON(entries);
        DeliverKeepLesson keepLesson = JSON.toJavaObject((JSON) o, DeliverKeepLesson.class);
        return keepLesson;
    }
}
