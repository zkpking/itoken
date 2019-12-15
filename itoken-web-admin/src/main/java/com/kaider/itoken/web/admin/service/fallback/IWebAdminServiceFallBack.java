package com.kaider.itoken.web.admin.service.fallback;

import com.google.common.collect.Lists;
import com.kaider.itoken.common.dto.BaseResult;
import com.kaider.itoken.common.utils.MapperUtils;
import com.kaider.itoken.web.admin.service.IWebAdminService;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

/**
 * @Author： kaider
 * @Date：2019/12/15 13:49
 * @描述：
 */
@Component
public class IWebAdminServiceFallBack implements IWebAdminService {

    @Override
    public String login(String userName, String password) {
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
