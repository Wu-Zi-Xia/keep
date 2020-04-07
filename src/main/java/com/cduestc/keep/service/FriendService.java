package com.cduestc.keep.service;

import com.cduestc.keep.mapper.FriendMapper;
import com.cduestc.keep.model.Friend;
import com.cduestc.keep.model.FriendExample;
import com.cduestc.keep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class FriendService {
    @Autowired
    UserService userService;
    @Autowired
    FriendMapper friendMapper;
    //添加一个好友关系
    public  int addFriend(String friendNumber, HttpSession session) {
        Friend friend=new Friend();
        friend.setFriendFriendid(userService.selectIDByNumber(friendNumber));
        User user = (User)session.getAttribute("user");
        friend.setFriendUserid(user.getUserId());
        int insert = friendMapper.insert(friend);
        return insert;
    }

    public List<Friend> getFriendByUserId(Long userId) {
        FriendExample friendExample=new FriendExample();
        friendExample.createCriteria().andFriendUseridEqualTo(userId);
        List<Friend> friends = friendMapper.selectByExample(friendExample);
        return friends;
    }
}
