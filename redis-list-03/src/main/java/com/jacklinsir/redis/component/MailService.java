package com.jacklinsir.redis.component;

import com.jacklinsir.redis.dto.MailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * 发送邮件服务
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 22:10
 */
@Slf4j
@Service
@EnableAsync
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    /**
     * 发送邮件
     */
    public void sendEmail(MailDto dto) {
        log.info("发送邮件");
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            //设置发送的邮箱
            helper.setFrom(env.getProperty("mail.notice.from"));
            //设置发送方
            helper.setTo(dto.getTos());
            helper.setSubject(dto.getSubject());
            //这里应该传入公告通知ID，默认先写死
            helper.setText(dto.getContent(), true);
            //设置发送的消息
            javaMailSender.send(mimeMessage);
            log.debug("邮件发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("发送邮件-异常: {}", e.fillInStackTrace());
        }
    }


}
