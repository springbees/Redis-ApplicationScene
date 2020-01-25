package com.jacklinsir.redis.component;

import com.jacklinsir.redis.common.Constant;
import com.jacklinsir.redis.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/24 13:32
 */
@Slf4j
@Service
public class RedisListService {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 将数据保存到redis数据库中
     *
     * @param product
     */
    public void pushRedisService(final Product product) {
        ListOperations<String, Product> listOperations = redisTemplate.opsForList();
        listOperations.leftPush(Constant.REDIS_KEY_LIST_PREFIX + product.getUserId(), product);
    }

    /**
     * 获取历史商品，有序取出
     *
     * @return
     */
    public List<Product> getHistoryProducts(final Integer userId) {
        List<Product> list = new LinkedList<>();
        ListOperations<String, Product> listOperations = redisTemplate.opsForList();
        final String redisKey = Constant.REDIS_KEY_LIST_PREFIX + userId;
        //取出指定范围内
        list = listOperations.range(redisKey, 0, listOperations.size(redisKey));
        log.info("--倒序：{}", list);

        //TODO:顺序
        Collections.reverse(list);
        log.info("--顺序：{}", list);

        //TODO:弹出来移除的方式
        //Product entity=listOperations.rightPop(key);
        //while (entity!=null){
        //list.add(entity);
        //entity=listOperations.rightPop(key);
        //}
        return list;
    }
}
