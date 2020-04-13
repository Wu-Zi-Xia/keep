package com.cduestc.keep.service;

import com.cduestc.keep.mapper.FriendCircleExMapper;
import com.cduestc.keep.mapper.FriendCircleMapper;
import com.cduestc.keep.mapper.FriendMapper;
import com.cduestc.keep.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class FriendService {
    @Autowired
    UserService userService;
    @Autowired
    FriendMapper friendMapper;
    @Value("${redis.keep.FriCirMyFriend}")
    String redisFriCirMyFriend;
    @Value("${redis.keep.FriCirMyFriendSort}")
    String redisFriCirMyFriendSort;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    PostService postService;
    @Autowired
    FriendCircleExMapper friendCircleExMapper;
    @Autowired
    FriendCircleMapper friendCircleMapper;
    //添加一个好友关系
    public  int addFriend(Long userId, User user) {
        Friend friend=new Friend();
        friend.setFriendFriendid(userId);
        friend.setFriendUserid(user.getUserId());
        int insert = friendMapper.insert(friend);
        //异步的删除redis中的我关注的朋友的动态的表
       if(redisTemplate.hasKey(redisFriCirMyFriendSort+user.getUserId())){
           Set redisPostIds = redisTemplate.opsForZSet().range(redisFriCirMyFriendSort + user.getUserId(), 0, -1);
           Iterator iterator = redisPostIds.iterator();
           while (iterator.hasNext()){
               String redisPostId = (String) iterator.next();
               redisTemplate.delete(redisPostId);
           }
           redisTemplate.delete(redisFriCirMyFriendSort+user.getUserId());
       }

        //可以异步的将我关注的这个朋友的动态都放入到我的朋友圈表
        List<Post> posts = postService.selectPostsByOwnerId(userId);
        List<FriendCircle> friendCircles=new ArrayList<>();
        Iterator<Post> iterator = posts.iterator();
        while(iterator.hasNext()){
            Post next = iterator.next();
            FriendCircle friendCircle=new FriendCircle();
            friendCircle.setCreateDate(next.getCreateDate());
            friendCircle.setIsOwn(0);
            friendCircle.setPostOwnerid(userId);
            friendCircle.setPostId(next.getPostId());
            friendCircle.setOwnerId(user.getUserId());
            friendCircles.add(friendCircle);
            friendCircleExMapper.insert(friendCircle);
        }
        //批量插入到数据库中去
        //friendCircleExMapper.insertFriCirS(friendCircles);
        return insert;
    }

    public List<Friend> getFriendByFriendId(Long userId) {
        FriendExample friendExample=new FriendExample();
        friendExample.createCriteria().andFriendFriendidEqualTo(userId);
        List<Friend> friends = friendMapper.selectByExample(friendExample);
        return friends;
    }

    public int deleteFriend(String userId, User user) {
        FriendExample friendExample=new FriendExample();
        FriendExample.Criteria criteria = friendExample.createCriteria();
        criteria.andFriendFriendidEqualTo(Long.parseLong(userId));
        criteria.andFriendUseridEqualTo(user.getUserId());
        //删除这条朋友的关系
        friendMapper.deleteByExample(friendExample);
        //异步的删除redis中的我关注的朋友的动态的表
        if(redisTemplate.hasKey(redisFriCirMyFriendSort+user.getUserId())){
            Set redisPostIds = redisTemplate.opsForZSet().range(redisFriCirMyFriendSort + user.getUserId(), 0, -1);
            Iterator iterator = redisPostIds.iterator();
            while (iterator.hasNext()){
                String redisPostId = (String) iterator.next();
                redisTemplate.delete(redisPostId);
            }
            redisTemplate.delete(redisFriCirMyFriendSort+user.getUserId());
        }
        //删除数据库中朋友圈表
        FriendCircleExample friendCircleExample=new FriendCircleExample();
        FriendCircleExample.Criteria criteria1 = friendCircleExample.createCriteria();
        criteria1.andIsOwnEqualTo(0);
        criteria1.andOwnerIdEqualTo(user.getUserId());
        criteria1.andPostOwneridEqualTo(Long.parseLong(userId));
        int i = friendCircleMapper.deleteByExample(friendCircleExample);
        return i;
    }
}
