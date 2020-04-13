package com.cduestc.keep.service;

import com.cduestc.keep.dto.AchieveUserINFO;
import com.cduestc.keep.dto.DeliverUserINFODTO;
import com.cduestc.keep.mapper.UserExMapper;
import com.cduestc.keep.mapper.UserMapper;
import com.cduestc.keep.model.User;
import com.cduestc.keep.model.UserExample;
import org.springframework.beans.BeanUtils;
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
        user.setUserNumber(number);
        user.setAvatarUrl("https://wuzixia-1300212146.cos.ap-chengdu.myqcloud.com/keep/avatarURL/37.png");
        int insert = userMapper.insert(user);
        //将用户信息放入session中保存登录状态
        session.setAttribute("user"+number,user);//放入session中，代表当前用户已经登陆
        return insert;
    }
    public Long selectIDByNumber(String number){

        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNumberEqualTo(number);
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0).getUserId();
    }

    public DeliverUserINFODTO getSimpleUserINFOById(long id){
        DeliverUserINFODTO deliverUserINFODTO = userExMapper.selectSimpleUserINFOByID(id);
        return deliverUserINFODTO;
    }

    public int update(AchieveUserINFO achieveUserINFO,Long userId) {
        User user=new User();
        if(achieveUserINFO.getHeight()!=0){
            user.setHeight(achieveUserINFO.getHeight());
        }else{
            user.setHeight(null);
        }
        if(achieveUserINFO.getAvatarUrl()!=null){
            user.setAvatarUrl(achieveUserINFO.getAvatarUrl());
        }
        else{
            user.setAvatarUrl(null);
        }
        if(achieveUserINFO.getWeight()!=0){
            user.setWeight(achieveUserINFO.getWeight());
        }
        else{
            user.setWeight(null);
        }
        if(achieveUserINFO.getNickname()!=null){
            user.setNickname(achieveUserINFO.getNickname());
        }
        else{
            user.setNickname(null);
        }
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        int i = userMapper.updateByExampleSelective(user, userExample);
        return i;
    }

    public User selectUserINFO(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
}
