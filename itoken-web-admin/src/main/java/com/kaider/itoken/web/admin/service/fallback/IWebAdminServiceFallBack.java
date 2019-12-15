package com.kaider.itoken.web.admin.service.fallback;

import com.kaider.itoken.web.admin.service.IWebAdminService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author： kaider
 * @Date：2019/12/15 13:49
 * @描述：
 */
@Component("")
public class IWebAdminServiceFallBack implements IWebAdminService {

    @Override
    public String login(String userName, String password) {
        return null;
    }
}
