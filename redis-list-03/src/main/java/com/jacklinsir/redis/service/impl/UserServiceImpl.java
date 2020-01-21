package com.jacklinsir.redis.service.impl;

import com.jacklinsir.redis.dao.UserDao;
import com.jacklinsir.redis.model.User;
import com.jacklinsir.redis.service.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/21 20:38
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> listAllUser() {
        return userDao.listAllUser();
    }
}
