package com.jakclinsir.redis.result;

/**
 * 封装api错误码
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 20:17
 */
public interface IErrorCode {

    /**
     * 获取响应状态码
     *
     * @return
     */
    long getCode();

    /**
     * 获取响应状态信息
     */
    String getMessage();
}
