package com.kaider.itoken.service.redis.controller;

import com.kaider.itoken.service.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author： kaider
 * @Date：2019/12/15 16:44
 * @描述：
 */
@RestController
public class RedisController {

    @Autowired
    private IRedisService redisService;

    /**
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    @PutMapping("put")
    public String put(String key, String value, long seconds) {
        redisService.put(key, value, seconds);
        return "ok";
    }

    /**
     * @param key
     * @return
     */
    @GetMapping("get")
    public String get(String key) {
        Object o = redisService.get(key);
        if (o != null) {
            String json = String.valueOf(o);
            return json;
        }
        return null;
    }

}
