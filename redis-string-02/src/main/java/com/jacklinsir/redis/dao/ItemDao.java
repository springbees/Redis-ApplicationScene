package com.jacklinsir.redis.dao;

import com.jacklinsir.redis.model.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 21:54
 */
public interface ItemDao {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into item(id,name,code,price,stock,create_time,update_time)" +
            "values (#{id} ,#{name} ,#{code} ,#{price} ,#{stock} ,#{createTime},#{updateTime})")
    int add(Item item);

    @Results(id = "baseResultMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "price", column = "price"),
            @Result(property = "stock", column = "stock"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    @Select("select id,name,code,price,stock,create_time,update_time from item where id=#{id} ")
    Item getByItemId(Integer id);

    @ResultMap(value = "baseResultMap")
    @Select("select id,name,code,price,stock,create_time,update_time from item")
    List<Item> queryAllItem();

}
