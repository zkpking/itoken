package com.kaider.itoken.web.admin.service.consumer.fallback;

import com.kaider.itoken.web.admin.service.consumer.IRedisService;
import org.springframework.stereotype.Component;

/**
 * @Author： kaider
 * @Date：2019/12/15 17:28
 * @描述：
 */
@Component
public class RedisServiceFallBack implements IRedisService {

    @Override
    public String put(String key, Object value, long seconds) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }
}
