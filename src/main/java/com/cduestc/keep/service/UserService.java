package com.cduestc.keep.service;

import com.cduestc.keep.mapper.UserExMapper;
import com.cduestc.keep.mapper.UserMapper;
import com.cduestc.keep.model.User;
import com.cduestc.keep.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserExMapper userExMapper;
    public int insertUser(String number, HttpSession session) {
        User user=new User();
        user.setUserNumber(Integer.valueOf(number));
        int insert = userExMapper.insert(user);
        session.setAttribute("user",user);//放入session中，代表当前用户已经登陆
        return insert;
    }
    public Long selectIDByNumber(String number){

        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNumberEqualTo(Integer.valueOf(number));
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0).getUserId();
    }
}
