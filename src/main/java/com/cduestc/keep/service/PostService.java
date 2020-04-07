package com.cduestc.keep.service;

import com.cduestc.keep.dto.DeliverCommentDto;
import com.cduestc.keep.dto.DeliverPostDTO;
import com.cduestc.keep.dto.DeliverUserINFODTO;
import com.cduestc.keep.dto.PostDto;
import com.cduestc.keep.enums.CommentTypeEnum;
import com.cduestc.keep.mapper.FriendCircleExMapper;
import com.cduestc.keep.mapper.PostExMapper;
import com.cduestc.keep.mapper.PostMapper;
import com.cduestc.keep.model.*;
import com.qcloud.cos.COSClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    PostExMapper postExMapper;
    @Autowired
    FileService fileService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    FriendService friendService;
    @Autowired
    FriendCircleService friendCircleService;
    @Autowired
    FriendCircleExMapper friendCircleExMapper;
    @Autowired
    RedisTemplate redisTemplate;
    public int insertNewPost(HttpSession session, PostDto newPost){

        User user = (User) session.getAttribute("user");
        newPost.setOwnerId(user.getUserId());//设置动态的拥有者
        //java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date formatTime = new Date(System.currentTimeMillis());
        newPost.setCreateDate(formatTime);//设置新建时间
        //System.out.println(newPost);
        int insert=0;
        Post post=new Post();
        BeanUtils.copyProperties(newPost,post);
        insert= postExMapper.insert(post);//post参数的id会直接返回当前插入动态的id
        //插入自己的朋友圈表
        FriendCircle friendCircle=new FriendCircle();
        friendCircle.setOwnerId(user.getUserId());
        friendCircle.setIsOwn(1);
        friendCircle.setPostId(post.getPostId());
        friendCircleExMapper.insert(friendCircle);
        redisTemplate.opsForList().leftPush("FriCir:"+friendCircle.getOwnerId(),friendCircle.getPostId());
        //插入当前这个用户的所有的朋友的friendCircle数据
        List<Friend> friendsByUserId = friendService.getFriendByUserId(user.getUserId());
        List<Long> IDS=new ArrayList<>();
        Iterator<Friend> friendIte = friendsByUserId.iterator();
        while(friendIte.hasNext()){
            Friend next = friendIte.next();
            FriendCircle friendCircle1=new FriendCircle();
            friendCircle1.setPostId(post.getPostId());
            friendCircle1.setOwnerId(next.getFriendFriendid());
            friendCircleExMapper.insert(friendCircle1);
            IDS.add(friendCircle1.getId());
            //同步到redis
            redisTemplate.opsForList().leftPush("FriCir:"+friendCircle1.getOwnerId(),friendCircle1.getId());
        }

        return insert;
    }


    public List<DeliverPostDTO> getPostByOwnerID(User user) {
        long ID=user.getUserId();
        //动态详情的list
        List<DeliverPostDTO> deliverPostDTOList=new ArrayList<>();
        DeliverPostDTO deliverPostDTO=new DeliverPostDTO();
        //获取发布者的简单信息
        DeliverUserINFODTO simpleUserINFOById = userService.getSimpleUserINFOById(ID);
       // BeanUtils.copyProperties(user,simpleUserINFOById);
        List<DeliverCommentDto> deliverCommentDtoList=new ArrayList<>();
        PostExample postExample=new PostExample();
        postExample.createCriteria().andOwnerIdEqualTo(ID);
        postExample.setOrderByClause("create_date desc");
        List<Post> posts = postMapper.selectByExample(postExample);//自己发的动态
        Iterator<Post> iterator1 = posts.iterator();
        List<Comment> comments=new ArrayList<>();
        while(iterator1.hasNext()){
            //设置发布者的简单信息
            deliverPostDTO.setDeliverUserINFODTO(simpleUserINFOById);
            //设置动态
            deliverPostDTO.setPost(iterator1.next());
            //获取每一条动态的一级评论：
            comments= commentService.getCommentsByOwnerId(iterator1.next().getPostId(), CommentTypeEnum.POST);

            Iterator<Comment> iterator = comments.iterator();
            while (iterator.hasNext()){
                DeliverCommentDto deliverCommentDto=new DeliverCommentDto();
                //设置一级评论
                deliverCommentDto.setComment(iterator.next());
                //设置评论的的二级评论
                deliverCommentDto.setCommentList(commentService.getCommentsByOwnerId(iterator.next().getCommentId(),CommentTypeEnum.COMMENT));//设置二级评论的list
                deliverCommentDtoList.add(deliverCommentDto);
            }
            //设置动态的一级评论
            deliverPostDTO.setComments(deliverCommentDtoList);
            deliverPostDTOList.add(deliverPostDTO);
        }
        return deliverPostDTOList;
    }

    public void getFriendPost(User user) {

    }
}
