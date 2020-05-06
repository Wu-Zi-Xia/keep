package com.cduestc.keep.service;

import com.cduestc.keep.dto.AchieveUserINFO;
import com.cduestc.keep.dto.DeliverSimpleUserINFODTO;
import com.cduestc.keep.dto.DeliverUserINFODto;
import com.cduestc.keep.exception.CustomizeErrorCode;
import com.cduestc.keep.exception.CustomizeException;
import com.cduestc.keep.mapper.UserExMapper;
import com.cduestc.keep.mapper.UserMapper;
import com.cduestc.keep.model.User;
import com.cduestc.keep.model.UserExample;
import com.cduestc.keep.provider.StringProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserExMapper userExMapper;
    @Autowired
    FriendService friendService;
    public int insertUser(String number, HttpSession session) {
        User user=new User();
        user.setUserNumber(number);
        user.setAvatarUrl("https://wuzixia-1300212146.cos.ap-chengdu.myqcloud.com/keep/avatarURL/37.png");
        String random = StringProvider.getRandomString(10);
        long l = System.currentTimeMillis();
        String randomNickname=random+l;
        user.setNickname(randomNickname);
        user.setState(1);
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

    public DeliverSimpleUserINFODTO getSimpleUserINFOById(long id){
        DeliverSimpleUserINFODTO deliverSimpleUserINFODTO = userExMapper.selectSimpleUserINFOByID(id);
        return deliverSimpleUserINFODTO;
    }
    //修改用户信息
    public int update(AchieveUserINFO achieveUserINFO,Long userId) {
        User user=new User();
        if(achieveUserINFO.getHeight()!=0){
            user.setHeight(achieveUserINFO.getHeight());
        }else{
            user.setHeight(null);
        }
        if(achieveUserINFO.getWeight()!=0){
            user.setWeight(achieveUserINFO.getWeight());
        }
        else{
            user.setWeight(null);
        }
        if(achieveUserINFO.getNickname()!=null){

            //判断是否已经存在这个昵称
            UserExample userExample=new UserExample();
            userExample.createCriteria().andNicknameEqualTo(achieveUserINFO.getNickname());
            List<User> users = userMapper.selectByExample(userExample);
            if(users.size()!=0){
                throw new CustomizeException(CustomizeErrorCode.NICK_NAME_IS_HAVE);
            }
            user.setNickname(achieveUserINFO.getNickname());
        }
        else{
            user.setNickname(null);
        }
        if(achieveUserINFO.getSex()!=null){
            user.setSex(achieveUserINFO.getSex());
        }
        else{
            user.setSex(null);
        }
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        int i = userMapper.updateByExampleSelective(user, userExample);
        return i;
    }

    public DeliverUserINFODto selectUserINFO(Long userId) {
        DeliverUserINFODto deliverUserINFODto=new DeliverUserINFODto();
        User user = userMapper.selectByPrimaryKey(userId);
        deliverUserINFODto.setUser(user);
        deliverUserINFODto.setFans(friendService.getFans(user));
        deliverUserINFODto.setFocus(friendService.getFocus(user));
        return deliverUserINFODto;
    }

    public String getSexById(User user){
        User user1 = userMapper.selectByPrimaryKey(user.getUserId());
        return user1.getSex();
    }

    public User selectUserByNumber(String number) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNumberEqualTo(number);
        List<User> users = userMapper.selectByExample(userExample);
        if(users==null||users.size()==0){
         return null;
        }
        return users.get(0);
    }

    public void updateStateByNumber(String number) {
        User user=new User();
        user.setState(1);
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNumberEqualTo(number);
        userMapper.updateByExampleSelective(user,userExample);
    }

    public User selectUserByID(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public String getAvatarURL(Long userId) {
        String s = userExMapper.selectAvatarURLByID(userId);
        return s;
    }

    public int updateAvatarURL(String newAvatarURLString, Long userId) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        User user=new User();
        user.setAvatarUrl(newAvatarURLString);
        int i = userMapper.updateByExampleSelective(user, userExample);
        return i;
    }
}
