package com.kaider.itoken.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author： kaider
 * @Date：2019/12/15 13:10
 * @描述：
 */
@SpringBootApplication(scanBasePackages = "com.kaider.itoken")
@EnableDiscoveryClient
@EnableFeignClients
public class WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }

}
