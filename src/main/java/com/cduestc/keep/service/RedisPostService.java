package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.DeliverCommentDto;
import com.cduestc.keep.dto.DeliverPostDTO;
import com.cduestc.keep.dto.DeliverUserINFODTO;
import com.cduestc.keep.mapper.UserExMapper;
import com.cduestc.keep.model.Comment;
import com.cduestc.keep.model.Post;
import com.cduestc.keep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RedisPostService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    DefaultRedisScript<List> defaultRedisScript;
    @Value("${redis.keep.FriCirMyself}")
    String redisFriTableNameM;
    @Value("${redis.keep.FriCirMyselfSort}")
    String redisFriCriSortSetM;
    @Value("${redis.keep.FriCirMyFriend}")
    String redisFriTableNameF;
    @Value("${redis.keep.FriCirMyFriendSort}")
    String redisFriCriSortSetF;
    @Autowired
    PostService postService;
    @Value("${domin}")
    String domin;
    @Autowired
    UserExMapper userExMapper;
    //插入到redis中
    public  void insert(String tableName, Object post,String type){
        //将计划信息放入到redis中
        JSON o = (JSON) JSON.toJSON(post);
        String text = o.toString();
        Map planMap= JSONObject.parseObject(text);
        switch (type){
            case "H":
                redisTemplate.opsForHash().putAll(tableName,planMap);
                break;
            case "L":
                redisTemplate.opsForList().leftPush(tableName,text);

        }


    }

    public void insertSort(DeliverPostDTO post,Long ID){
        JSON o = (JSON) JSON.toJSON(post);
        String text = o.toString();
        Map postMap= JSONObject.parseObject(text);
        Long createDate = post.getPost().getCreateDate();
        Long postId = post.getPost().getPostId();
        redisTemplate.opsForZSet().add(redisFriCriSortSetM+ID,redisFriTableNameM+postId.toString(),createDate);
        redisTemplate.opsForHash().putAll(redisFriTableNameM+postId,postMap);
    }
    public void insertFriendSort(DeliverPostDTO post,Long ID){
        JSON o = (JSON) JSON.toJSON(post);
        String text = o.toString();
        Map postMap= JSONObject.parseObject(text);
        Long createDate = post.getPost().getCreateDate();
        Long postId = post.getPost().getPostId();
        redisTemplate.opsForZSet().add(redisFriCriSortSetF+ID,redisFriTableNameF+postId.toString(),createDate);
        redisTemplate.opsForHash().putAll(redisFriTableNameF+postId,postMap);
    }


    public List<DeliverPostDTO> getPostByOwnerID(User user, int offset, int size, HttpServletResponse response) throws IOException {
        List<DeliverPostDTO> deliverPostDTOList=new ArrayList<>();
        long ID=user.getUserId();
        Long friLen= redisTemplate.opsForZSet().zCard(redisFriCriSortSetM + ID);
        if(offset>=friLen){//代表redis中没有用户想要查的数据，这样必须要去数据库刷新十条数据
            int mysqlOffset=Integer.parseInt(friLen.toString());
            int mysqlSize=10;
            deliverPostDTOList = postService.getPostByOwnerID(user, mysqlOffset, mysqlSize);
            if(!deliverPostDTOList.get(0).isEnd()){//数据没有取出来完，就可以重定向
            response.sendRedirect(domin+"getPosts?"+"offset="+offset+"&size="+size);
            return null;
            }
            return deliverPostDTOList;
        }
        //从redis中取出用户想要的数据
        Set set = redisTemplate.opsForZSet().reverseRange(redisFriCriSortSetM + ID, offset, size);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String next = (String)iterator.next();
            Map entries = redisTemplate.opsForHash().entries(next);
            Object o = JSONObject.toJSON(entries);
            DeliverPostDTO deliverPostDTO=JSONObject.toJavaObject((JSON) o, DeliverPostDTO.class);
            deliverPostDTOList.add(deliverPostDTO);
        }
        return deliverPostDTOList;
    }

    public List<DeliverPostDTO> getFriendPostByOwnerID(User user, int offset, int size, HttpServletResponse response) throws IOException {
        List<DeliverPostDTO> deliverPostDTOList=new ArrayList<>();
        long ID=user.getUserId();
        Long friLen= redisTemplate.opsForZSet().zCard(redisFriCriSortSetF + ID);
        if(offset>=friLen){//代表redis中没有用户想要查的数据，这样必须要去数据库刷新十条数据
            int mysqlOffset=Integer.parseInt(friLen.toString());
            int mysqlSize=10;
            deliverPostDTOList = postService.getFriendPostByOwnerId(user, mysqlOffset, mysqlSize);
            if(!deliverPostDTOList.get(0).isEnd()){//数据没有取出来完，就可以重定向
                response.sendRedirect(domin+"getFriendPosts?"+"offset="+offset+"&size="+size);
                return null;
            }
            return deliverPostDTOList;
        }
        //从redis中取出用户想要的数据
        Set set = redisTemplate.opsForZSet().reverseRange(redisFriCriSortSetF + ID, offset, size);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String next = (String)iterator.next();
            Map entries = redisTemplate.opsForHash().entries(next);
            Object o = JSONObject.toJSON(entries);
            DeliverPostDTO deliverPostDTO=JSONObject.toJavaObject((JSON) o, DeliverPostDTO.class);
            deliverPostDTOList.add(deliverPostDTO);
        }
        return deliverPostDTOList;
    }

    public void updateLikeCount(String keyName,int num) {
        Map entries = redisTemplate.opsForHash().entries(keyName);
        Object o = JSONObject.toJSON(entries);
        DeliverPostDTO deliverPostDTO = JSONObject.toJavaObject((JSON) o, DeliverPostDTO.class);
        Post post = deliverPostDTO.getPost();
        post.setLikeCount(post.getLikeCount()+num);
        //将修改好的字段重新放入redis中
        JSON jsons = (JSON)JSON.toJSON(post);
        Map paramMap = JSONObject.parseObject(jsons.toString());
        redisTemplate.opsForHash().putAll(keyName,paramMap);
    }

    public List<String> getZan(String key) {
        Set members = redisTemplate.opsForSet().members(key);
        if(members==null||members.size()==0){
            return null;
        }
        List<String> avatarURLs= userExMapper.selectAvatarURLByIDs(members);
        return avatarURLs;
    }

    public boolean isEnpty(String keyName) {
      return   redisTemplate.hasKey(keyName);
    }

}
