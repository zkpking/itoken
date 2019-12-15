package com.kaider.itoken.common.hystrix;

import com.google.common.collect.Lists;
import com.kaider.itoken.common.dto.BaseResult;
import com.kaider.itoken.common.utils.MapperUtils;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

/**
 * @Author： kaider
 * @Date：2019/12/15 17:34
 * @描述：
 */
public class FallBack {

    /**
     * 502错误
     *
     * @return
     */
    public static String badGeteway() {
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
