package com.cduestc.keep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisShopCarService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    DefaultRedisScript<List> defaultRedisScript;
    public void addProduct(){

    }
}
