package com.jakclinsir.redis.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 20:38
 */
@Data
@Builder
public class Employee implements Serializable {

    private Long id;
    private String username;
    private BigDecimal salary;
    private Integer age;
    /**
     * true表示女
     * false表示男
     */
    private boolean sex;
}
