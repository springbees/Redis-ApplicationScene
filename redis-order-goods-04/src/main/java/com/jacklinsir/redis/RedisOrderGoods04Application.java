package com.jacklinsir.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author linSir
 */
@MapperScan("com.jacklinsir.redis.dao")
@SpringBootApplication
public class RedisOrderGoods04Application {

    public static void main(String[] args) {
        SpringApplication.run(RedisOrderGoods04Application.class, args);
    }

}
