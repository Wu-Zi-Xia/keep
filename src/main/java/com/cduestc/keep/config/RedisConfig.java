package com.cduestc.keep.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.cduestc.keep.provider.serialize.FastJsonRedisSerializer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.List;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * RedisTemplate配置
     * @param connectionFactory
     * @return
     */
    /**
     * 重写Redis序列化方式，使用Json方式:
     * 当我们的数据存储到Redis的时候，我们的键（key）和值（value）都是通过Spring提供的Serializer序列化到数据库的。RedisTemplate默认使用的是JdkSerializationRedisSerializer，StringRedisTemplate默认使用的是StringRedisSerializer。
     * Spring Data JPA为我们提供了下面的Serializer：
     * GenericToStringSerializer、Jackson2JsonRedisSerializer、JacksonJsonRedisSerializer、JdkSerializationRedisSerializer、OxmSerializer、StringRedisSerializer。
     * 在此我们将自己配置RedisTemplate并定义Serializer。
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        // 全局开启AutoType，不建议使用
        // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        // 建议使用这种方式，小范围指定白名单
//        ParserConfig.getGlobalInstance().addAccept("com.cduestc.keep");
//        ParserConfig.getGlobalInstance().addAccept("java.lang.String");
        // 设置值（value）的序列化采用FastJsonRedisSerializer。
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        //这里我解决了hash不能取到对象的某一个变量值的问题
        //redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        //这里我解决了list取值的序列化问题
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    @Bean
    public DefaultRedisScript<List> redisScript() {
        DefaultRedisScript<List> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luaScript/select1.lua")));
        redisScript.setResultType(List.class);
        return redisScript;
    }

}
