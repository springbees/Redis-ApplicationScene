package com.jacklinsir.redis.component;

import com.jacklinsir.redis.common.Constant;
import com.jacklinsir.redis.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis服务
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 21:38
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Notice> redisTemplate;


    /**
     * 保存数据到redis服务器
     */
    public void push(Notice notice) {
        ListOperations<String, Notice> listOperations = redisTemplate.opsForList();
        listOperations.leftPush(Constant.KEY_NOTICE_ID, notice);
    }

    /**
     * 根据键去redis服务器取出数据
     *
     * @param key
     * @return
     */
    public List<Notice> rightPop(String key) {
        ListOperations<String, Notice> listOperations = redisTemplate.opsForList();
        List<Notice> list = new ArrayList<>();
        list.add(listOperations.rightPop(key));
        while (list.size() > 0) {
            //Redis服务器中数据取出保存到集合中
            list.add(listOperations.rightPop(key));
        }
        return list;
    }

}
