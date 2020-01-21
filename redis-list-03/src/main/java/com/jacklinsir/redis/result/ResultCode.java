package com.jacklinsir.redis.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * API通用响应状态码和信息
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 20:59
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements IErrorCode {

    SUCCESS(200, "请求成功！"),
    FIELD(500, "请求失败！");

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
