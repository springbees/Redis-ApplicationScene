package com.jacklinsir.redis.service;

import com.jacklinsir.redis.model.Notice;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 21:27
 */
public interface INoticeService {

    /**
     * 添加通知商户公告
     *
     * @param notice
     * @return
     */
    int pushNotice(Notice notice);

    /**
     * 根据ID查询Notice
     * @param id
     * @return
     */
    Notice getByNoticeId(Integer id);
}
