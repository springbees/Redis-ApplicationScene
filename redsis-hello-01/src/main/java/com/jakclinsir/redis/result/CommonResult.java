package com.jakclinsir.redis.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装通用的结果返回对象
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 20:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * 状态码
     */

    private long code;
    /**
     * 消息结果
     */
    private String message;
    /**
     * 返回的结果对象
     */
    private T data;

    /**
     * 返回成功并返回结果对象
     *
     * @param data 结果对象
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
        return new CommonResult<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

}
