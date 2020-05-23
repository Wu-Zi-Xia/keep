package com.cduestc.keep.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.*;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.model.*;
import com.cduestc.keep.provider.CookieProvider;
import com.cduestc.keep.provider.GetRequestBody;
import com.cduestc.keep.service.*;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


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
    @Autowired
    FriendService friendService;
    @Autowired
    ZanService zanService;
    @Value("${redis.keep.hot.posts}")
    String redisHotPostsSortSet;
    @Value("${redis.keep.hot.posts.name}")
    String redisHotPostsTableName;
    @Autowired
    FileService fileService;
    @Value("redis.keep.recomend.posts")
    String recomendPostSort;
    @Value("redis.keep.recomend.posts.name")
    String rrecomendPostTable;
    //创建动态(已经测试)
    @RequestMapping(value = "createPost",method = RequestMethod.POST)
    public @ResponseBody Object createPost(HttpServletRequest request,
                                           @RequestParam(value = "video",required = false) MultipartFile video,
                                           @RequestParam(value = "description",required = false) String description) throws IOException {

        //查找登录人
        String token = request.getHeader("token");
        User user=(User) request.getSession().getAttribute(sessionNamePre+token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
        MultipartFile[] files = getImageFiles(multipartRequest);
        //从files中取出数据
        if((files.length==0)&&video==null&&description==null){//发布动态不能为空
            throw new CustomizeException(CustomizeErrorCode.RESOURCE_IS_NULL);
        }
        if((files.length!=0)&&(video!=null)){//不能同时发布图片和视频
            throw new CustomizeException(CustomizeErrorCode.RESOURCE_IS_FULL);
        }

        PostDto newPost=new PostDto();
        //上传图片，然后返回地址
            if(files.length!=0){//发图片
                String s = fileService.uploadPostImages(files);
                newPost.setImageUrl(s);
            }
        //上传视频，然后返回地址
        if(video!=null){//发视频
            if(!video.isEmpty()){
                String s = fileService.uploadPostVideo(video);
                newPost.setVideoUrl(s);
            }
        }
        if(description==null){
            newPost.setDescription("");
        }
        if(description!=null){
            newPost.setDescription(description);
        }
        if(video==null&&files.length==0&&description!=null){//只发文字
            newPost.setDescription(description);
        }
        //插入数据库
        int i = postService.insertNewPost(user, newPost);
       //向前端返回数据
         if(i>0)
         {
            return ResultDto.oxOf();
         }
        return ResultDto.errorOf(500,"发表动态失败！！");
    }
     //辅助方法，获取图片
    public  MultipartFile[] getImageFiles(MultipartHttpServletRequest request){
        List<MultipartFile> files=new ArrayList<>();
        MultipartFile file=null;
        String baseFileName="file";
        for(int i=1;i<10;i++){
             file= request.getFile(baseFileName + i);
            if(file==null){//如果第一个值就为null，证明没有传图片过来，或者遍历到一个null的值，就直接退出
                break;
            }
            files.add(file);
        }
        //将list转成数组
        MultipartFile[] files1 = new MultipartFile[files.size()];
        files.toArray(files1);
        return files1;
    }


    @RequestMapping("getRecommend")
    //判断用户是否是有特别的编号，并且不是当前用户已经关注的人
    public Object Recommend(HttpServletRequest request,
                               @RequestParam(name = "offset") Long redisOffset,
                               @RequestParam(name = "size") Long redisSize){
        //获取cookie
        String token = request.getHeader("token");
        //获取登录的用户id
        User user = (User)request.getSession().getAttribute(sessionNamePre+token);
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        if(1==1){//到redis中去查询
           redisPostService.getRecommend(redisOffset,redisSize,user.getUserId());
        }
       else{//从数据库里面去查询
            Long mysqlOffset=0l;
            Long mysqlSize=10l;
            List<DeliverRecomendDto> recommend = postService.getRecommend(mysqlOffset, mysqlSize);
            return ResultDto.oxOf(recommend);
        }
       return null;
    }
     @RequestMapping("getHot")
    //或者他的粉丝数量特别多，或者他的粉丝数量特别多，或者他的粉丝数量特别多，或者他的粉丝数量特别多，
     public Object getHot(@RequestParam("page") int page,
                          HttpServletRequest request){
         String token = request.getHeader("token");
         //获取登录的用户id
         User user = (User) request.getSession().getAttribute(sessionNamePre + token);
         if(user==null){
             throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
         }
         List<DeliverPostDTO> hotPosts;
        if(redisTemplate.hasKey(redisHotPostsSortSet)){//存在键值就从redis中去查找
            int redisSize=5;
            List<DeliverPostDTO> hot = redisPostService.getHot(page, user.getUserId(), redisSize);
            return ResultDto.oxOf(hot);
        }
        else{//从mysql中去查找
            int mysqlSize=10;
             hotPosts= postService.getHot(page, mysqlSize);
        }
        return ResultDto.oxOf(hotPosts);
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
        if(user==null){
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        List<DeliverPostDTO> postByOwnerID;
        if(redisTemplate.hasKey(redisFriCriSortSetM+user.getUserId())){
            //redis里面去取值
            postByOwnerID=redisPostService.getPostByOwnerID(user,redisOffset,redisSize,response);
            return ResultDto.oxOf(postByOwnerID);
        }
        else {
            int mysqlOffset=redisOffset;
            int mysqlSize=10;
            //从数据库里面去查找10条数据，前5条返回给前端
            postByOwnerID= postService.getPostByOwnerID(user,mysqlOffset,mysqlSize);
            return ResultDto.oxOf(postByOwnerID);
            }
        }
        //return ResultDto.errorOf(500,"");

    //获取推荐的用户

    //获取朋友的动态
    @RequestMapping("getFriendPosts")
    public @ResponseBody Object getFriendPost(HttpServletRequest request,
                                @RequestParam(name = "offset",defaultValue ="0") int redisOffset,
                                @RequestParam(name = "size",defaultValue="4") int redisSize,
                                HttpServletResponse response) throws IOException {

        if (redisOffset < 0 || redisSize <= 0) {
            return ResultDto.errorOf(1012, "参数非法！！");
        }
        //获取cookie
        String token = request.getHeader("token");
        //获取登录的用户id
        User user = (User) request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        long l = friendService.countFriendByUserId(user.getUserId());
        if(l==0){
           return ResultDto.errorOf(1000,"还没有关注的人哦！！");
        }
        List<DeliverPostDTO> postByOwnerID;
        if (redisTemplate.hasKey(redisFriCriSortSetF+ user.getUserId())) {
            //redis里面去取值
            postByOwnerID = redisPostService.getFriendPostByOwnerID(user, redisOffset, redisSize, response);
            return ResultDto.oxOf(postByOwnerID);
        } else {
            int mysqlOffset = redisOffset;
            int mysqlSize = 10;
            //从数据库里面去查找50条数据，前十条返回给前端
            List<DeliverPostDTO> friendPostByOwnerId = postService.getFriendPostByOwnerId(user, mysqlOffset, mysqlSize);
            //response.sendRedirect(domin + "getFriendPosts?" + "offset=" + redisOffset + "&size=" + redisSize);
                return ResultDto.oxOf(friendPostByOwnerId);

        }
    }


    //获取动态详情
    @RequestMapping("getPost")
    public @ResponseBody  Object getPost(@RequestParam("postId") String postId,
                                         HttpServletRequest request,
                                         HttpServletResponse response) throws IOException {
        String token = request.getHeader("token");
        User user =(User) request.getSession().getAttribute(sessionNamePre+token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
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
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
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
                         HttpServletResponse response,
                                       HttpServletRequest request) throws IOException {
        String token = request.getHeader("token");
        User user = (User)request.getSession().getAttribute(sessionNamePre + token);
        if(user==null){
            return ResultDto.errorOf(1004,"用户未登录");
        }
        String keyName = redisZanTableName + postId;
        if(redisTemplate.hasKey(keyName)){//如果存在就从redis里面查
            DeliverZanDto deliverZanDto=new DeliverZanDto();
            List<String> avatarURLs= redisPostService.getZan(keyName);
            //先要判断当前用户是否已经点赞
            boolean isZan = zanService.isZan(postId, user.getUserId());
            deliverZanDto.setAvatarURLs(avatarURLs);
            deliverZanDto.setZan(!isZan);
            return ResultDto.oxOf(deliverZanDto);
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
