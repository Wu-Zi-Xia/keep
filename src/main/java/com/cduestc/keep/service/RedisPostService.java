package com.cduestc.keep.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cduestc.keep.dto.DeliverCommentDto;
import com.cduestc.keep.dto.DeliverPostDTO;
import com.cduestc.keep.dto.DeliverUserINFODTO;
import com.cduestc.keep.model.Comment;
import com.cduestc.keep.model.Post;
import com.cduestc.keep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RedisPostService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    DefaultRedisScript<List> defaultRedisScript;
    public List<DeliverPostDTO> getPostByOwnerID(User user){

        List<DeliverPostDTO> deliverPostDTOList=new ArrayList<>();
        long ID=user.getUserId();
        if(!redisTemplate.hasKey("keepUser:"+ID)){//看redis中是否有键
            //将用户信息放入到redis中
            JSON o = (JSON) JSON.toJSON(user);
            Map userMap=JSONObject.parseObject(o.toString());
            redisTemplate.opsForHash().putAll("keepUser:"+ID,userMap);
        }
        //获取用户的简单信息
        DeliverUserINFODTO deliverUserINFODTO=new DeliverUserINFODTO();
        deliverUserINFODTO.setUserId(ID);
        deliverUserINFODTO.setAvatarUrl((String) redisTemplate.opsForHash().get("keepUser:" + ID, "avatar_url"));
        deliverUserINFODTO.setNickname((String) redisTemplate.opsForHash().get("keepUser:" + ID, "nickname"));
        List<String> postKeyList= new ArrayList<>();

        //首先直接看redis里面的用户是否存在
        if(redisTemplate.hasKey("keepUser:"+ID)){
            //去redis中查找当前用户的所有动态
            if(redisTemplate.hasKey("userPost:"+ID)){
                //存在就直接从redis里面去查找
                //获取所有的动态的key值
                postKeyList = redisTemplate.opsForList().range("userPost:" + ID, 0, -1);
                Iterator iterator = postKeyList.iterator();
                int i=0;
                while(iterator.hasNext()){
                    Object next = iterator.next();
                    //System.out.println(next);
                    i++;
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
                            execute(defaultRedisScript,
                                    new StringRedisSerializer(),
                                    new StringRedisSerializer(),
                                    Collections.singletonList("keepComment:*"),
                                    "owner_ID",postMysqlID,"type","1");
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
        }




        return deliverPostDTOList;
    }
}
