package com.kaider.itoken.web.admin.service;

import com.kaider.itoken.web.admin.service.fallback.IWebAdminServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author： kaider
 * @Date：2019/12/15 13:49
 * @描述：
 */
@FeignClient(value = "itoken-service-admin",fallback = IWebAdminServiceFallBack.class)
public interface IWebAdminService {

    @GetMapping("login")
    String login(String userName,String password);

}
