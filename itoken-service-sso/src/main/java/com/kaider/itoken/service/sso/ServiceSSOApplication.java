package com.kaider.itoken.service.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author： kaider
 * @Date：2019/12/15 16:48
 * @描述：
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.kaider.itoken.service.sso.mapper")
public class ServiceSSOApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSSOApplication.class, args);
    }


}
