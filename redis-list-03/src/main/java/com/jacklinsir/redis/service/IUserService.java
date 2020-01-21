package com.jacklinsir.redis.service;

import com.jacklinsir.redis.model.User;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/21 20:38
 */
public interface IUserService {

    List<User> listAllUser();
}
