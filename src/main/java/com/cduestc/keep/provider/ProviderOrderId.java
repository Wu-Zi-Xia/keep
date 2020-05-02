package com.cduestc.keep.provider;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;
@Component
public class ProviderOrderId {
    @Autowired
    private RedisTemplate redisTemplate;
    private  static String REDIS_MANAGE_ORDER_PREFIX = "yuy:manage:Order_INC";
    private  static String REDIS_MANAGE_ORDER_ITEM_PREFIX = "yuy:manage:Order_Item_INC";


    public String getOrderId() {
        String key = REDIS_MANAGE_ORDER_PREFIX;
        if(!redisTemplate.hasKey(key)){
           redisTemplate.opsForValue().set(key,"1");
        }
        //合同编号规则: BNF + 当前日期 + 四位编号，编号每天从1开始递增
        String currentDate = DateFormatUtils.format(new Date(), "yyyyMMdd");

        long count = redisTemplate.opsForValue().increment(key, 1);
        if (count == 1) {
            redisTemplate.expireAt(key, getTimeout());
        }
        return String.format("%s%s", currentDate, String.format("%04d", count));
    }

    private Date getTimeout() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
    public String getOrderItemId() {
        String key = REDIS_MANAGE_ORDER_ITEM_PREFIX;
        if(!redisTemplate.hasKey(key)){
            redisTemplate.opsForValue().set(key,"1");
        }
        //合同编号规则: BNF + 当前日期 + 四位编号，编号每天从1开始递增
        String currentDate = DateFormatUtils.format(new Date(), "yyyyMMdd");
        long count = redisTemplate.opsForValue().increment(key, 1);
        if (count == 1) {
            redisTemplate.expireAt(key, getTimeout());
        }
        return String.format("%s%s", currentDate, String.format("%04d", count));
    }
}
