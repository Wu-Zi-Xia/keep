package com.cduestc.keep.interceptor;

import com.cduestc.keep.mapper.UserMapper;
import com.cduestc.keep.model.User;
import com.cduestc.keep.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
//作用是让session一直存在，当服务器关闭之后
@Service
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    UserMapper userMapper;
    @Value("${cookie.name.preFix}")
    private String cookieNamePre;
    @Value("${session.name.preFix}")
    private String sessionNamePre;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String token = request.getHeader("token");
        if(token!=null){
            UserExample userExample=new UserExample();
            userExample.createCriteria().andUserNumberEqualTo(token);
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size()!=0){
                request.getSession().setAttribute(sessionNamePre+token,users.get(0));
            }
        }
        return true;
    }
}
