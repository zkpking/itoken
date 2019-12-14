package com.kaider.itoken.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author： kaider
 * @Date：2019/12/14 23:02
 * @描述：
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.kaider.itoken.service.admin.mapper")
public class ServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }

}
