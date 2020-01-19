package com.jacklinsir.redis.service;

import com.jacklinsir.redis.model.Item;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 22:10
 */
public interface ItemService {

    /**
     * 添加
     *
     * @param item
     * @return
     */
    int add(Item item);

    /**
     * 根据itemId查询
     *
     * @param id
     * @return
     */
    Item getByItemId(Integer id);
}
