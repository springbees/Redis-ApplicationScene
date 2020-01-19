package com.jacklinsir.redis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacklinsir.redis.component.StringRedisService;
import com.jacklinsir.redis.dao.ItemDao;
import com.jacklinsir.redis.model.Item;
import com.jacklinsir.redis.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 22:15
 */
@Slf4j
@Service
public class ItemServiceImpl implements ItemService {
    /**
     * 注入dao组件
     */
    @Autowired
    private ItemDao itemDao;

    /**
     * 注入Redis服务组件
     */
    @Autowired
    private StringRedisService redisService;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(Item item) {
        //补充相关属性初始化值
        item.setCreateTime(new Date());
        item.setId(null);
        int index = itemDao.add(item);
        Integer id = item.getId();
        //判断一下保证缓存和数据库双写一致性
        if (index > 0) {
            //将数据序列化成json保存到redis 缓存中
            try {
                redisService.put("item:" + id.toString(), objectMapper.writeValueAsString(item));
                log.info("item数据保存到缓存中成功: {}", item);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                log.info("item数据保存到缓存中异常: {}", e.getMessage());
            }
        }
        return index;
    }

    /**
     * 根据ID获取商品
     *
     * @param id
     * @return
     */
    @Override
    public Item getByItemId(Integer id) {
        if (id != null) {
            //根据ID判断键是否存在
            if (redisService.exist("item:" + id.toString())) {
                String data = redisService.get("item:" + id.toString());
                try {
                    log.info("item-缓存中查询结果: {}", data);
                    return objectMapper.readValue(data, Item.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                //去查询数据库
                Item item = itemDao.getByItemId(id);
                if (item != null) {
                    return item;
                }
                return null;
            }
        }
        return null;
    }
}
