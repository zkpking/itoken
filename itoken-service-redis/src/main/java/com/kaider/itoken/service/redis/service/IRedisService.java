package com.kaider.itoken.service.redis.service;

/**
 * @Author： kaider
 * @Date：2019/12/15 16:39
 * @描述：
 */
public interface IRedisService {

    /**
     *
     * @param key
     * @param value
     * @param seconds 超时时间
     */
    void put(String key, Object value, long seconds);

    Object get(String key);

}
