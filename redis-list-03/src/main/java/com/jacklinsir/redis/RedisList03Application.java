package com.jacklinsir.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jacklinsir.redis.dao")
@SpringBootApplication
public class RedisList03Application {

    public static void main(String[] args) {
        SpringApplication.run(RedisList03Application.class, args);
    }

}
