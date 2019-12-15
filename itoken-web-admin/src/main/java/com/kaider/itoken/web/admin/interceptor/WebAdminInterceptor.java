package com.kaider.itoken.web.admin.interceptor;

import com.kaider.itoken.common.utils.CookieUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * @Author： kaider
 * @Date：2019/12/15 20:30
 * @描述：初始化常量拦截器
 */
public class WebAdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtils.getCookieValue(request, "token");
        if(isBlank(token)){
            try {
                response.sendRedirect("http://localhost:8503/login?url=http://localhost:8601");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO: 2019/12/15 此处针对常量进行拦截跳转
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
