package com.kaider.itoken.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author： kaider
 * @Date：2019/12/15 13:10
 * @描述：
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }



}
