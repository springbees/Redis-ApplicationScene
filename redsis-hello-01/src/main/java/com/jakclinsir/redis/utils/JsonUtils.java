package com.jakclinsir.redis.utils;

import com.alibaba.fastjson.JSON;
import com.jakclinsir.redis.po.Employee;

import java.math.BigDecimal;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 20:52
 */
public class JsonUtils {

    public static void main(String[] args) {


        String toJSONString = JSON.toJSONString(Employee.builder().id(1L).username("小明").sex(true).age(22).salary(new BigDecimal("12000")).build());
        System.out.println("toJSONString = " + toJSONString);
    }

}
