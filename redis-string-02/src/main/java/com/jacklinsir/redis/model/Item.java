package com.jacklinsir.redis.model;

import com.jacklinsir.redis.model.base.BasePojo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 22:10
 */
@Data
public class Item extends BasePojo {
    private Integer id;
    private String name;
    private String code;
    private BigDecimal price;
    private Long stock;
}
