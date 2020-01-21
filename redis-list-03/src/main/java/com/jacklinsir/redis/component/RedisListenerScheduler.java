package com.jacklinsir.redis.component;

import com.jacklinsir.redis.common.Constant;
import com.jacklinsir.redis.dto.MailDto;
import com.jacklinsir.redis.model.Notice;
import com.jacklinsir.redis.model.User;
import com.jacklinsir.redis.service.INoticeService;
import com.jacklinsir.redis.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定时扫描管理员添加的公告发送给商户
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 21:53
 */
@Slf4j
@Component
@EnableScheduling
public class RedisListenerScheduler {

    @Autowired
    private RedisService redisService;


    @Autowired
    private INoticeService noticeService;

    @Autowired
    private IUserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private Environment env;


    @Scheduled(cron = "0 * * * * ?")
    public void schedulerListenNotice() {
        log.info("----定时任务调度队列监听、检测通告消息，监听list中的数据");
        //去Redis服务器查询数据
        List<Notice> notices = redisService.rightPop(Constant.KEY_NOTICE_ID);
        //定时任务执行到当前对象不为空则调用发送邮件服务，给商户发送邮件
        while (notices.size() > 0) {
            //TODO调用发送邮件
            notices.forEach(notice -> {
                this.sendEmailMerchant(notice);
            });
        }


    }

    //TODO:发送通知给到不同的商户
    public void sendEmailMerchant(Notice notice) {
        List<Notice> notices = redisService.rightPop(Constant.KEY_NOTICE_ID);
        if (notices.size() > 0) {
            List<User> users = userService.listAllUser();
            users.forEach(user -> {
                log.info("近实时的定时任务检测-发送通知给到不同的商户 - ID: {}", user.getId());
                String content = String.format(notice.getContent(), user.getId());
                MailDto mailDto = new MailDto(notice.getTitle(), content, new String[]{user.getEmail()});
                mailService.sendEmail(mailDto);
            });
        }
    }


}
