package com.kaider.itoken.web.admin.config;

import com.kaider.itoken.web.admin.interceptor.WebAdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author： kaider
 * @Date：2019/12/15 20:35
 * @描述：
 */
@Configuration
public class WebAdminInterceptorConfig implements WebMvcConfigurer {

    /**
     * 在此处注入Interceptor
     *
     * @return
     */
    @Bean
    WebAdminInterceptor webAdminInterceptor() {
        return new WebAdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webAdminInterceptor())
                .addPathPatterns("/**")//拦截所有地址
                .excludePathPatterns("/static");//过滤静态文件
    }
}
