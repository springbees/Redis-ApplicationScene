package com.jacklinsir.redis.dao;

import com.jacklinsir.redis.model.Notice;
import org.apache.ibatis.annotations.*;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 21:22
 */
public interface NoticeDao {

    /**
     * push进去公告通知
     *
     * @param notice
     * @return
     */
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into notice(title,content,is_active) values (#{title} ,#{content} ,#{isActive} )")
    int pushNotice(Notice notice);

    /**
     * 根据ID查询Notice对象数据
     *
     * @param id
     * @return
     */
    @Results(id = "BaseResultMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "isActive", column = "is_active")
    })
    @Select("select  id ,title,content,is_active from notice where id=#{id} ")
    Notice getByNoticeId(Integer id);
}
