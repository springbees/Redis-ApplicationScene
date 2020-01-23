package com.jacklinsir.redis.service.impl;

import com.jacklinsir.redis.common.Constant;
import com.jacklinsir.redis.dao.NoticeDao;
import com.jacklinsir.redis.model.Notice;
import com.jacklinsir.redis.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * 实现活动通知商户实现
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 21:28
 */
@Slf4j
@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int pushNotice(Notice notice) {
        if (ObjectUtils.isEmpty(notice)) {
            throw new RuntimeException("参数异常");
        }
        notice.setId(null);
        notice.setIsActive(1);
        //TODO将数据塞入到数据库中
        int pushNotice = noticeDao.pushNotice(notice);
        final Integer id = notice.getId();
        //这一步判断保证数据的双写一致性
        if (pushNotice > 0 && id > 0) {
            //插入到redis数据库中
            ListOperations listOperations = redisTemplate.opsForList();
            //将数据保存到redis服务器
            listOperations.leftPush(Constant.KEY_NOTICE_ID, notice);
            log.info("数据添加到Redis数据库中: {}", notice);
        }
        return pushNotice;
    }

    @Override
    public Notice getByNoticeId(Integer id) {
        if (id > 0 && id != null) {
            throw new RuntimeException("ID参数异常");
        }
        return noticeDao.getByNoticeId(id);
    }
}
