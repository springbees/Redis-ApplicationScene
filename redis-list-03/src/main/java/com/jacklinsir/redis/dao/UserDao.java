package com.jacklinsir.redis.dao;

import com.jacklinsir.redis.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/21 20:35
 */
public interface UserDao {

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "passwotd"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "updateTime")
    })
    @Select("select id,username,password,phone,email,is_active,create_time,update_time from user")
    List<User> listAllUser();
}
