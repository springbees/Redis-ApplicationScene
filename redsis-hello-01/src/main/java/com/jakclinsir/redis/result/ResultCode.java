package com.jakclinsir.redis.result;

import lombok.*;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 20:19
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements IErrorCode {

    //枚举定义一些响应结果装
    SUCCESS(200, "请求成功！"),
    FAILED(500, "请求失败！");

    /**
     * 响应状态码
     */
    private long code;

    /**
     * 响应状态信息
     */
    private String message;


    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
