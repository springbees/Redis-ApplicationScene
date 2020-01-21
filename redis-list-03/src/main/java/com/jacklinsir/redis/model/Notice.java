package com.jacklinsir.redis.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 21:18
 */
@Data
public class Notice implements Serializable {

    private Integer id;

    private String title;

    private String content;

    //发送状态
    private Integer isActive;


}
