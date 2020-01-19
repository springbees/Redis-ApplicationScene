package com.jacklinsir.redis.result;

/**
 * 定义通用返回装状态码和状态信息
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 21:39
 */
public interface IErrorCode {

    /**
     * 返回状态码
     *
     * @return
     */
    long getCode();

    /**
     * 返回结果信息
     *
     * @return
     */
    String getMessage();

}
