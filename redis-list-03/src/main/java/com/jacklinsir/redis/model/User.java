package com.jacklinsir.redis.model;

import lombok.Data;

import java.util.Date;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/21 20:26
 */
@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer isActive;
    private Date createTime;
    private Date updateTime;
}
