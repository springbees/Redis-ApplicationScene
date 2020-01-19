package com.jacklinsir.redis.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 22:13
 */
@Data
public class BasePojo implements Serializable {

    private Date createTime;
    private Date updateTime;
}
