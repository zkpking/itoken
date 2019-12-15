package com.kaider.itoken.web.admin.service.fallback;

import com.google.common.collect.Lists;
import com.kaider.itoken.common.dto.BaseResult;
import com.kaider.itoken.common.utils.MapperUtils;
import com.kaider.itoken.web.admin.service.IWebAdminService;
import org.springframework.stereotype.Component;

/**
 * @Author： kaider
 * @Date：2019/12/15 13:49
 * @描述：
 */
@Component
public class IWebAdminServiceFallBack implements IWebAdminService {

    @Override
    public String login(String userName, String password) {
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("502", "网络连接错误")));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
