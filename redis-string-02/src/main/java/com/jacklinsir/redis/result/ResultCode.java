package com.jacklinsir.redis.result;

import lombok.AllArgsConstructor;

/**
 * 枚举一些通用结果状态方法
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 21:41
 */
@AllArgsConstructor
public enum ResultCode implements IErrorCode {

    SUCCESS(200, "请求成功！"),
    FAILED(500, "请求失败");

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
