package com.jacklinsir.redis.utils;

import com.alibaba.fastjson.JSON;
import com.jacklinsir.redis.model.Item;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 23:18
 */
@Slf4j
public class JsonUtils {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("张三");
        item.setCode("ITEM123456789");
        item.setPrice(new BigDecimal("888"));
        item.setStock(520L);
        System.out.println(JSON.toJSONString(item));

        log.info("测试info");
        log.debug("测试debug");
        log.warn("测试warn");
        log.error("测试error");
    }
}
