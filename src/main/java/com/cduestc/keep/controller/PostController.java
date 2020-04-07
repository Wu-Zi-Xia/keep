package com.cduestc.keep.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.*;
import com.cduestc.keep.model.Comment;
import com.cduestc.keep.model.Post;
import com.cduestc.keep.model.User;
import com.cduestc.keep.provider.GetRequestBody;
import com.cduestc.keep.service.PostService;

import com.cduestc.keep.service.RedisPostService;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class PostController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    PostService postService;
    @Autowired
    RedisPostService redisPostService;
    @Autowired
    DefaultRedisScript<List> defaultRedisScript;

    //创建动态
    @RequestMapping(value = "createPost",method = RequestMethod.POST)
    public @ResponseBody Object createPost(HttpServletRequest request/**@RequestBody PostDto newPost**/) throws IOException {
        String requestBody = GetRequestBody.getRequestBody(request);
        JSONObject jsonObject= JSON.parseObject(requestBody);
        PostDto newPost=new PostDto();
        newPost.setVideoUrl((String) jsonObject.get("videoUrl"));
        newPost.setImageUrl((String) jsonObject.get("imageUrl"));
        newPost.setDescription((String) jsonObject.get("description"));
        BeanUtils.copyProperties(jsonObject,newPost);
       //System.out.println(newPost);
        int i = postService.insertNewPost(request.getSession(), newPost);
        if(i>0) {
            return ResultDto.oxOf();
        }
        return ResultDto.errorOf(300,"发表动态失败！！");
    }

    //获取本人的动态
    @RequestMapping("getPost")
    public @ResponseBody Object getPost(HttpServletRequest request){
        //获取登录的用户id
        User user = (User)request.getSession().getAttribute("user");
        List<DeliverPostDTO> postByOwnerID;
        if(redisTemplate.hasKey("userPost:"+user.getUserId())){
            //redis里面去取值
            postByOwnerID=redisPostService.getPostByOwnerID(user);
            System.out.println("redis");
        }
        else {
            //从数据库里面去查找
             postByOwnerID= postService.getPostByOwnerID(user);
            if (postByOwnerID == null || postByOwnerID.size() == 0) {
                return ResultDto.errorOf(500, "你还没有发布动态哦！！");
            }
        }
        return  ResultDto.oxOf(postByOwnerID);
    }

    //获取朋友的动态
    @RequestMapping("getFriendPost")
    public Object getFriendPost(HttpServletRequest request,
                                @RequestParam(value="pos",defaultValue = "1")long pos,
                                @RequestParam(value="offset",defaultValue = "10") long offset){
        User user = (User)request.getSession().getAttribute("user");
        DeliverUserINFODTO deliverUserINFODTO=new DeliverUserINFODTO();
        List<DeliverPostDTO> deliverPostDTOList=new ArrayList<>();
        deliverUserINFODTO.setNickname(user.getNickname());
        deliverUserINFODTO.setAvatarUrl(user.getAvatarUrl());
        deliverUserINFODTO.setUserId(user.getUserId());
        String redisTableName="FriCir:"+user.getUserId();
        if(redisTemplate.hasKey(redisTableName)){//看用户的朋友圈是否在redis中存在
            List redisPostIDs = redisTemplate.opsForList().range(redisTableName, pos, offset);
            Iterator iterator = redisPostIDs.iterator();
                while(iterator.hasNext()){//遍历动态的id
                    Object next = iterator.next();
                    DeliverPostDTO deliverPostDTO
                            =new DeliverPostDTO();
                    //设置返回的用户的简单信息
                    deliverPostDTO.setDeliverUserINFODTO(deliverUserINFODTO);

                    Map entries = redisTemplate.opsForHash().entries(next);
                    JSON json = (JSON) JSON.toJSON(entries);
                    Post post = JSONObject.toJavaObject(json,Post.class);
                    String postKey = next.toString();
                    String postMysqlID = postKey.substring(postKey.length() - 1);
                    post.setPostId(Long.parseLong(postMysqlID));
                    //设置动态的详细信息
                    deliverPostDTO.setPost(post);
                    //评论的操作
                    List<DeliverCommentDto> deliverCommentDtoList=new ArrayList<>();

                    List keepCommentIDs1 =(List) redisTemplate.
                            execute(defaultRedisScript,new StringRedisSerializer(), new StringRedisSerializer(),
                                    Collections.singletonList("keepComment:*"),"owner_ID",postMysqlID,"type","1");
                    if(keepCommentIDs1.size()!=0){//证明当前这条动态是有评论的
                        Iterator iterator2 = keepCommentIDs1.iterator();
                        while(iterator2.hasNext()){
                            String commentRedisKey =(String)iterator2.next();
                            DeliverCommentDto deliverCommentDto=new DeliverCommentDto();
                            Map entries1 = redisTemplate.opsForHash().entries(commentRedisKey);
                            JSON json1 = (JSON) JSON.toJSON(entries1);
                            Comment comment =JSONObject.toJavaObject(json1,Comment.class);
                            comment.setCommentId(Long.parseLong(commentRedisKey.substring(commentRedisKey.length()-1)));
                            deliverCommentDto.setComment(comment);//将一级评论设置上去
                            //截取redis的key的最后一个
                            String commentMysqlID = commentRedisKey.substring(commentRedisKey.length()-1);
                            List keepCommentIDs2 =(List) redisTemplate.
                                    execute(defaultRedisScript,new StringRedisSerializer(), new StringRedisSerializer(),
                                            Collections.singletonList("keepComment:*"),"owner_ID",commentMysqlID,"type","2");
                            if (keepCommentIDs2.size()!=0){//当前评论的二级评论存在
                                Iterator iterator1 = keepCommentIDs2.iterator();
                                List <Comment> commentList=new ArrayList<>();
                                while(iterator1.hasNext()){//循环的将二级评论查询出来

                                    String commentRedisKey2 = (String) iterator1.next();
                                    Map entries2 = redisTemplate.opsForHash().entries(commentRedisKey2);
                                    JSON json2 = (JSON) JSON.toJSON(entries2);
                                    Comment comment2 =JSONObject.toJavaObject(json2,Comment.class);
                                    comment2.setCommentId(Long.parseLong(commentRedisKey2.substring(commentRedisKey2.length()-1)));
                                    commentList.add(comment2);
                                }
                                deliverCommentDto.setCommentList(commentList);//将二级评论设置上去
                            }
                            deliverCommentDtoList.add(deliverCommentDto);
                        }
                        deliverPostDTO.setComments(deliverCommentDtoList);//将一个动态的评论设置上去
                    }
                    deliverPostDTOList.add(deliverPostDTO);

                }
        }
        return deliverPostDTOList;
    }
    //点赞功能
    @RequestMapping("zan")
    public Object zan(@RequestParam(value = "ID" )long ID,
                    HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        String tableName="zan:"+ID;
        Long userId = user.getUserId();
        ResultDto<Boolean> resultDto=new ResultDto<>();
        if(redisTemplate.opsForSet().isMember(tableName,userId)){//看当前用户是否已经点赞
            redisTemplate.opsForSet().remove(tableName,userId);
            //发异步请求到mysql修改字段
            resultDto.setCode(200);
            resultDto.setData(false);
            return resultDto;
        }
        else{
        redisTemplate.opsForSet().add(tableName,userId);
            //发异步请求到mysql修改字段
        resultDto.setData(true);
        resultDto.setCode(200);
        }
        resultDto.setCode(500);
        resultDto.setData(null);
        return resultDto;
    }

}
