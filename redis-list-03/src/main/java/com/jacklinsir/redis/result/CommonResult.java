package com.jacklinsir.redis.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用的结果集对象
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/20 20:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private long code;

    private String message;

    private T data;


    /**
     * 返回成功的对象信息
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }


    /**
     * 返回失败的结果对象
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> filed() {
        return new CommonResult<>(ResultCode.FIELD.getCode(), ResultCode.FIELD.getMessage(), null);
    }
}
