package com.cduestc.keep.controller;

import com.cduestc.keep.dto.DeliverKeepLesson;
import com.cduestc.keep.dto.ResultDto;
import com.cduestc.keep.model.KeepLesson;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.service.ChooseLessonService;
import com.cduestc.keep.service.LessonService;
import com.cduestc.keep.service.RedisLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class LessonController {
    @Autowired
    LessonService lessonService;
    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @Value("${redis.keep.lessonTable}")
    String redisLessonTable;
    @Value("${redis.keep.lessonTableSort}")
    String redisLessonTableSort;
    @Value("${domin}")
    String domin;
    @Value("${redis.keep.myLesson}")
    String redisMyLessonTable;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisLessonService redisLessonService;
    @Autowired
    ChooseLessonService chooseLessonService;

    //获取热门课程
    @RequestMapping("getHotLesson")
             public @ResponseBody Object getHotLesson(HttpServletRequest request,
                                                      HttpServletResponse response
                                                      ) throws IOException {
           List<KeepLesson> hotLesson=null;
            if(redisTemplate.hasKey(redisLessonTableSort)){//判断redis中是否有hotLesson的数据
                hotLesson = redisLessonService.getHotLesson(response);
            }
            else{//没有就去数据库里面查询，然后加入redis
                 lessonService.getHotLesson();
                 response.sendRedirect(domin+"getHotLesson");
                 return null;
            }
              return ResultDto.oxOf(hotLesson);
             }

             //获取系列课程
             @RequestMapping("getSystemLesson")
             public @ResponseBody Object getSystemLesson(HttpServletResponse response,
                                                         @RequestParam(name="more",required = false) String more) throws IOException {
                    if(redisTemplate.hasKey(redisLessonTableSort)){//redis中存在就返回数据

                        List<KeepLesson> systemLesson = redisLessonService.getSystemLesson(response, more);
                        return ResultDto.oxOf(systemLesson);
                    }
                    else{//redis中不存在,就去数据库里面查询然后同步到redis中
                        lessonService.getHotLesson();
                        if(more!=null){
                            response.sendRedirect(domin+"getSystemLesson?more="+more);
                            return null;
                        }
                        else{
                            response.sendRedirect(domin+"getSystemLesson");
                            return null;
                        }
                    }
             }
        @RequestMapping("addLesson")
        public @ResponseBody Object addLesson(HttpServletRequest request,
                                          @RequestParam(name = "id")Long id){
            String token = request.getHeader("token");
            User user = (User) request.getSession().getAttribute(sessionNamePre + token);
        lessonService.addLesson(user,id);
        return ResultDto.oxOf("添加课程成功！！");
    }
    @RequestMapping("getMyLesson")
    public @ResponseBody Object getMyLesson(HttpServletRequest request){
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre + token);
        List<KeepLesson> lessonByOwnerId = chooseLessonService.getLessonByOwnerId(user);
        if(lessonByOwnerId==null){
            return ResultDto.errorOf(500,"您还没有添加的课程！！");
        }
        else{
            return ResultDto.oxOf(lessonByOwnerId);
        }
    }
    @RequestMapping("getLessonById")
    public  @ResponseBody Object getLessonById(@RequestParam("id") Long id,HttpServletResponse response) throws IOException {
        if(redisTemplate.hasKey(redisLessonTable+id.toString())){
            DeliverKeepLesson lessonById = redisLessonService.getLessonById(id);
            if(lessonById!=null){
             return ResultDto.oxOf(lessonById);
            }
            else{
                return ResultDto.oxOf("课程不存在！！");
            }
        }
        else{
            lessonService.getHotLesson();
            response.sendRedirect(domin+"getLessonById?id="+id);
            return null;
        }
    }
}
