package com.kaider.itoken.web.admin.interceptor;

import com.kaider.itoken.common.domain.TbSysUser;
import com.kaider.itoken.common.utils.CookieUtils;
import com.kaider.itoken.common.utils.MapperUtils;
import com.kaider.itoken.web.admin.service.consumer.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * @Author： kaider
 * @Date：2019/12/15 20:30
 * @描述：初始化常量拦截器
 */
public class WebAdminInterceptor implements HandlerInterceptor {


    @Autowired
    private IRedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtils.getCookieValue(request, "token");
        if (isBlank(token)) {
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
        HttpSession session = request.getSession();
        TbSysUser user = (TbSysUser) session.getAttribute("userInfo");
        //已登录
        if (user != null) {
            if (modelAndView != null) {
                modelAndView.addObject("userInfo", user);
            }
        } else {
            //未登录
            String token = CookieUtils.getCookieValue(request, "token");
            if (isNotBlank(token)) {
                String loginJson = redisService.get(token);
                if (isNotBlank(loginJson)) {
                    String userJson = redisService.get(loginJson);
                    if (isNotBlank(userJson)) {
                        try {
                            //已登录状态 创建局部会话
                            user = MapperUtils.json2pojo(userJson, TbSysUser.class);

                            if (modelAndView != null) {
                                modelAndView.addObject("userInfo", user);
                            }

                            request.getSession().setAttribute("userInfo", user);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }

        if (user == null) {
            try {
                response.sendRedirect("http://localhost:8503/login?url=http://localhost:8601");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
