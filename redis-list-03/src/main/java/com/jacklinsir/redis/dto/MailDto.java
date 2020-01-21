package com.jacklinsir.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 发送邮件参数封装
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/21 20:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {
    //邮件主题
    private String subject;
    //邮件内容
    private String content;
    //接收人
    private String[] tos;
}

