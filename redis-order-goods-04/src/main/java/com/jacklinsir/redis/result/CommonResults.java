package com.jacklinsir.redis.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用的结果集返回对象
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/24 13:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResults<T> {

    private long code;
    private String message;
    private T data;


    /**
     * 返回成功，并返回数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResults<T> success(T data) {
        return new CommonResults<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }


    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> CommonResults<T> failure() {
        return new CommonResults<>(ResultCode.FAILURE.getCode(), ResultCode.FAILURE.getMessage(), null);
    }

}
