package com.kaider.itoken.service.sso.service.consumer.fallback;

import com.google.common.collect.Lists;
import com.kaider.itoken.common.dto.BaseResult;
import com.kaider.itoken.common.utils.MapperUtils;
import com.kaider.itoken.service.sso.service.consumer.IRedisService;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

/**
 * @Author： kaider
 * @Date：2019/12/15 17:28
 * @描述：
 */
@Component
public class RedisServiceFallBack implements IRedisService {

    @Override
    public String put(String key, Object value, long seconds) {
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(BAD_GATEWAY.value()), BAD_GATEWAY.getReasonPhrase()
                )
        ));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String get(String key) {
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(BAD_GATEWAY.value()), BAD_GATEWAY.getReasonPhrase()
                )
        ));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
