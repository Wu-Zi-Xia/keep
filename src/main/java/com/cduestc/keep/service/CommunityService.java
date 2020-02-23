package com.cduestc.keep.service;

import com.cduestc.keep.dto.CommunityDto;
import com.cduestc.keep.mapper.CommentMapper;
import com.cduestc.keep.mapper.FriendMapper;
import com.cduestc.keep.mapper.PostMapper;
import com.cduestc.keep.mapper.UserMapper;
import com.cduestc.keep.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CommunityService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    FriendMapper friendMapper;
    @Autowired
    PostMapper postMapper;
    @Autowired
    CommentMapper commentMapper;
    //获取关注的好友的动态
    public List<CommunityDto> getFriendPost(HttpSession session)
    {
         List<CommunityDto> communityDtoList=new ArrayList<>();
        User user = (User) session.getAttribute("user");
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNumberEqualTo(user.getUserNumber());
        List<User> users = userMapper.selectByExample(userExample);//查到当前登录用户的所有信息
        //获取到当前用户的所有朋友
        FriendExample friendExample=new FriendExample();
        friendExample.createCriteria().andFriendUseridEqualTo(users.get(0).getUserId());
        List<Friend> friends = friendMapper.selectByExample(friendExample);
        //获取动态
        Iterator<Friend> iterator = friends.iterator();
        List<Post> posts = null;
          while(iterator.hasNext()){
              Long friendFriendid = iterator.next().getFriendFriendid();
              PostExample postExample=new PostExample();
              postExample.createCriteria().andOwnerIdEqualTo(friendFriendid);
              posts = postMapper.selectByExample(postExample);//获取每个人的所有动态
              //获取动态的拥有者的详细信息

                  UserExample userExample1=new UserExample();
                  userExample1.createCriteria().andUserIdEqualTo(friendFriendid);
                  List<User> users1 = userMapper.selectByExample(userExample1);
                  CommentExample commentExample=new CommentExample();

              Iterator<Post> iterator1 = posts.iterator();
              while(iterator1.hasNext()){
                  CommunityDto communityDto=new CommunityDto();
                  communityDto.setAvatarUrl(users1.get(0).getAvatarUrl());
                  communityDto.setNickname(users1.get(0).getNickname());
                  communityDto.setImageUrl(iterator1.next().getImageUrl());
                  communityDto.setVideoUrl(iterator1.next().getVideoUrl());
                  communityDto.setDescription(iterator1.next().getDescription());
                  commentExample.createCriteria().andOwnerIdEqualTo(iterator1.next().getPostId());
                  List<Comment> comments = commentMapper.selectByExample(commentExample);
                  communityDto.setComment(comments);
                  communityDtoList.add(communityDto);
              }
          }

        return communityDtoList;
    }
}
