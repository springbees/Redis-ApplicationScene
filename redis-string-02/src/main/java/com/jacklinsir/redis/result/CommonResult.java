package com.jacklinsir.redis.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用的返回结果对象
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 21:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Long code;

    private String message;

    private T data;


    /**
     * 返回成果并返回请求对象
     *
     * @param data 携带响应参数
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }


    /**
     * 返回请求失败的结果对象
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> fail() {
        return new CommonResult<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

}
