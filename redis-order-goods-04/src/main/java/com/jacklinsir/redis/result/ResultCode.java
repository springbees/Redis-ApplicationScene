package com.jacklinsir.redis.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 枚举定义一些相关状态码提示信息
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/24 13:11
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements IErrorCode {

    SUCCESS(200L, "请求成功！"),
    FAILURE(500L, "请求失败！");

    private long code;
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
