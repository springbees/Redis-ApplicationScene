package com.jakclinsir.redis.controller;

import com.jakclinsir.redis.po.Employee;
import com.jakclinsir.redis.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 20:34
 */
@Slf4j
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;
    public static final String reidsKey = "SpringbootRedis:Employee";

    @PostMapping("/put")
    public CommonResult redisPut(@RequestBody Employee employee) {
        try {
            if (employee != null) {
                //保存进入Redis
                redisTemplate.opsForValue().set(reidsKey, employee.toString());
                return CommonResult.success("hello world！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("保存数据进去Redis发生异常: {}", e.getMessage());
        }
        return CommonResult.filed();
    }

    @GetMapping("/get")
    public CommonResult redisGet() {
        try {
            return CommonResult.success(redisTemplate.opsForValue().get(reidsKey));
        } catch (Exception e) {
            e.printStackTrace();
            log.info("获取redis数据发生异常了: {}", e.getMessage());
        }
        return CommonResult.filed();
    }
}
