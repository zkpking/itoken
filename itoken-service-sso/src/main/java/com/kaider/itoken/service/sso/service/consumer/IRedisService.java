package com.kaider.itoken.service.sso.service.consumer;

import com.kaider.itoken.service.sso.service.consumer.fallback.RedisServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author： kaider
 * @Date：2019/12/15 16:39
 * @描述：
 */
@FeignClient(value = "itoken-service-redis",fallback = RedisServiceFallBack.class)
public interface IRedisService {

    /**
     * @param key
     * @param value
     * @param seconds 超时时间
     */
    @PutMapping("put")
    String put(
            @RequestParam("key") String key,
            @RequestParam("value") Object value,
            @RequestParam("seconds") long seconds
    );

    @GetMapping("get")
    String get(@RequestParam("key") String key);

}
