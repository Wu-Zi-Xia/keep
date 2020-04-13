package com.cduestc.keep.provider;

import com.cduestc.keep.model.User;
import com.cduestc.keep.model.UserExample;
import lombok.Data;

import javax.servlet.http.Cookie;
import java.util.List;

@Data
public class CookieProvider {
    public static Cookie getCookie(Cookie[] cookies,String cookieName){
        if(cookies!=null&&cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)){

                   return cookie;
                }
            }
        }
        return null;
    }
}
