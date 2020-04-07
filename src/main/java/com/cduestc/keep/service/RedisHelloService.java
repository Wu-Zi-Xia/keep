package com.cduestc.keep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisHelloService {
    @Autowired
    RedisTemplate redisTemplate;

    public Long setVerifyCode(String num,String ver) {
        redisTemplate.opsForValue().set(num,ver,60, TimeUnit.SECONDS);
        return 60l;
    }
    public boolean isEnptyKey(String key){
        return redisTemplate.hasKey(key);
    }

}
