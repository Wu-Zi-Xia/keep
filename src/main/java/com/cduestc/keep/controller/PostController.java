package com.cduestc.keep.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.*;
import com.cduestc.keep.model.Comment;
import com.cduestc.keep.model.Post;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.provider.GetRequestBody;
import com.cduestc.keep.service.PostService;

import com.cduestc.keep.service.RedisPostService;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
@Slf4j
@RestController
public class PostController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    PostService postService;
    @Autowired
    RedisPostService redisPostService;
    @Autowired
    DefaultRedisScript<List> defaultRedisScript;
    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @Value("${redis.keep.FriCirMyself}")
    String redisFriTableNameM;
    @Value("${redis.keep.FriCirMyselfSort}")
    String redisFriCriSortSetM;
    @Value("${domin}")
    String domin;
    @Value("${redis.keep.zan}")
    String redisZanTableName;
    @Value("${redis.keep.FriCirMyFriend}")
    String redisFriTableNameF;
    @Value("${redis.keep.FriCirMyFriendSort}")
    String redisFriCriSortSetF;
    //创建动态(已经测试)
    @RequestMapping(value = "createPost",method = RequestMethod.POST)
    public @ResponseBody Object createPost(HttpServletRequest request,
                                           @RequestBody PostDto newPost) throws IOException {
       //获取前端传过来的数据
//        String requestBody = GetRequestBody.getRequestBody(request);
//        JSONObject jsonObject= JSON.parseObject(requestBody);
        //查找登录人
        String token = request.getHeader("token");
        User user = null;
        if(token!=null){
         user=(User) request.getSession().getAttribute(sessionNamePre+token);
        }
        else{
            return ResultDto.errorOf(500,"还没有登录！！");
        }
        //插入数据库
        int i = postService.insertNewPost(user, newPost);
        //向前端返回数据
        if(i>0) {
            return ResultDto.oxOf();
        }
        return ResultDto.errorOf(500,"发表动态失败！！");
    }

    //获取本人的动态
    @RequestMapping("getPosts")
    public @ResponseBody Object getPost(HttpServletRequest request,
                                        @RequestParam(name = "offset",defaultValue ="0") int redisOffset,
                                        @RequestParam(name = "size",defaultValue="4") int redisSize,
                                        HttpServletResponse response) throws IOException {
        if(redisOffset<0||redisSize<=0){
           return ResultDto.errorOf(500,"参数非法！！");
        }
        //获取cookie
        String token = request.getHeader("token");
        //获取登录的用户id
        User user = (User)request.getSession().getAttribute(sessionNamePre+token);
        List<DeliverPostDTO> postByOwnerID;
        if(redisTemplate.hasKey(redisFriCriSortSetM+user.getUserId())){
            //redis里面去取值
            postByOwnerID=redisPostService.getPostByOwnerID(user,redisOffset,redisSize,response);
            if (postByOwnerID == null||postByOwnerID.size() == 0) {
                return ResultDto.errorOf(500, "你还没有发布动态哦！！");
            }
            if(postByOwnerID.get(0).isEnd()){
                return ResultDto.errorOf(500,"不能再刷新了！！");
            }
            else{
                return ResultDto.oxOf(postByOwnerID);
            }
            }
        else {
            int mysqlOffset=redisOffset;
            int mysqlSize=10;
            //从数据库里面去查找50条数据，前十条返回给前端
             postByOwnerID= postService.getPostByOwnerID(user,mysqlOffset,mysqlSize);
            if (postByOwnerID == null || postByOwnerID.size() == 0) {
                return ResultDto.errorOf(500, "你还没有发布动态哦！！");
            }
            if(postByOwnerID.get(0).isEnd()){
                return ResultDto.errorOf(500,"不能再刷新了！！");
            }else{
                response.sendRedirect(domin+"getPosts?"+"offset="+redisOffset+"&size="+redisSize);
                return null;
            }
        }
        //return ResultDto.errorOf(500,"");
    }

    //获取朋友的动态
    @RequestMapping("getFriendPosts")
    public @ResponseBody Object getFriendPost(HttpServletRequest request,
                                @RequestParam(name = "offset",defaultValue ="0") int redisOffset,
                                @RequestParam(name = "size",defaultValue="4") int redisSize,
                                HttpServletResponse response) throws IOException {

        if (redisOffset < 0 || redisSize <= 0) {
            return ResultDto.errorOf(500, "参数非法！！");
        }
        //获取cookie
        String token = request.getHeader("token");
        //获取登录的用户id
        User user = (User) request.getSession().getAttribute(sessionNamePre + token);
        List<DeliverPostDTO> postByOwnerID;
        if (redisTemplate.hasKey(redisFriCriSortSetF+ user.getUserId())) {
            //redis里面去取值
            postByOwnerID = redisPostService.getFriendPostByOwnerID(user, redisOffset, redisSize, response);
            if (postByOwnerID == null || postByOwnerID.size() == 0) {
                return ResultDto.errorOf(500, "你的朋友还没有发布动态哦！！");
            }
            if (postByOwnerID.get(0).isEnd()) {
                System.out.println("redis");
                return ResultDto.errorOf(500, "不能再刷新了！！");
            } else {
                return ResultDto.oxOf(postByOwnerID);
            }

        } else {
            int mysqlOffset = redisOffset;
            int mysqlSize = 10;
            //从数据库里面去查找50条数据，前十条返回给前端
            postByOwnerID = postService.getFriendPostByOwnerId(user, mysqlOffset, mysqlSize);
            if (postByOwnerID == null || postByOwnerID.size() == 0) {
                return ResultDto.errorOf(500, "你的朋友还没有发布动态哦！！");
            }
            if (postByOwnerID.get(0).isEnd()) {
                return ResultDto.errorOf(500, "不能再刷新了！！");
            } else {
                response.sendRedirect(domin + "getFriendPosts?" + "offset=" + redisOffset + "&size=" + redisSize);
                return null;
            }
        }
    }

    //获取动态详情
    @RequestMapping("getPost")
    public @ResponseBody  Object getPost(@RequestParam("postId") String postId,
                                         HttpServletRequest request,
                                         HttpServletResponse response) throws IOException {
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre+token);
        if(redisTemplate.hasKey(redisFriCriSortSetM+user.getUserId())){//判断redis中是否有值
            Map entries = redisTemplate.opsForHash().entries(redisFriTableNameM+postId);
            JSON o = (JSON)JSONObject.toJSON(entries);
            DeliverPostDTO deliverPostDTO = JSON.toJavaObject(o, DeliverPostDTO.class);
            return ResultDto.oxOf(deliverPostDTO);
        }
        else{//从数据库里面去查出来，然后放入到redis中
            DeliverPostDTO postByOwnerID = postService.getPostByOwnerID(user,postId);
            response.sendRedirect(domin+"getPost?postId="+postId);
            return null;
        }
    }

    //点赞功能
    @RequestMapping("zan")
    public Object zan(@RequestParam(value = "postId" )long postId,
                    HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        String token = request.getHeader("token");
        User user = (User)request.getSession().getAttribute(sessionNamePre + token);
        String keyName=redisZanTableName+postId;
        Long userId = user.getUserId();
        if(redisPostService.isEnpty(keyName)){//存在当前键值对
            //redis里面去更新赞的信息
            boolean isZan=postService.updateZan(keyName, userId, postId);
            return  ResultDto.oxOf(isZan);
        }else{//不存在当前键值对
            //去数据库获取用户id并且更新到redis中
            postService.getZan(keyName,postId);
            //更新完了之后再让前端访问一次这个接口，重定向
            response.sendRedirect(domin+"zan?"+"postId="+postId);
            return null;
        }
    }

    //获取当前动态的所有赞的功能
    @RequestMapping("getZan")
    public @ResponseBody Object getZan(@RequestParam(name ="postId") long postId,
                         HttpServletResponse response) throws IOException {
        String keyName = redisZanTableName + postId;
        if(redisTemplate.hasKey(keyName)){//如果存在就从redis里面查
            List<String> avatarURLs= redisPostService.getZan(keyName);
            return ResultDto.oxOf(avatarURLs);
        }
        else//不存在
        {
            //去数据库获取用户id并且更新到redis中
            postService.getZan(keyName,postId);
            //更新完了之后再让前端访问一次这个接口，重定向
            response.sendRedirect(domin+"getZan?"+"postId="+postId);
            return null;
        }
    }

}
