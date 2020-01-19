package com.jacklinsir.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis服务组件
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 22:18
 */
@Service
public class StringRedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 向redis存储数据
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        redisTemplate.opsForValue().set(key, value.toString());
    }


    /**
     * 从redis获取数据
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据key判断是否存在
     *
     * @param key
     * @return
     */
    public boolean exist(String key) {
        return redisTemplate.opsForValue().get(key) != null;
    }
}
