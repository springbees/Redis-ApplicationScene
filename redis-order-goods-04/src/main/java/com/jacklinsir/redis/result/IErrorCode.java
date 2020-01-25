package com.jacklinsir.redis.result;

/**
 * 信息提示接口
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/24 13:10
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
