package com.jacklinsir.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品pojo类
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/24 13:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product implements Serializable {
    private Integer id;
    private String name;
    private Integer userId;
    private Integer scanTotal;
    private Integer isActive;
}
