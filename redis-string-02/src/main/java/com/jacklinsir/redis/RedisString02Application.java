package com.jacklinsir.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jacklinsir.redis.dao")
@SpringBootApplication
public class RedisString02Application {

    public static void main(String[] args) {
        SpringApplication.run(RedisString02Application.class, args);
    }

}
