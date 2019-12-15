package com.kaider.itoken.service.sso.controller;

import com.kaider.itoken.common.domain.TbSysUser;
import com.kaider.itoken.common.utils.CookieUtils;
import com.kaider.itoken.common.utils.MapperUtils;
import com.kaider.itoken.service.sso.service.ILoginAuthService;
import com.kaider.itoken.service.sso.service.consumer.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * @Author： kaider
 * @Date：2019/12/15 17:49
 * @描述：
 */
@Controller
public class LoginController {

    @Autowired
    private ILoginAuthService service;

    @Autowired
    private IRedisService redisService;

    /**
     * 登录
     *
     * @param url
     * @param request
     * @param model
     * @return
     */
    @GetMapping("login")
    public String login(
            @RequestParam(required = false) String url,
            HttpServletRequest request,
            Model model
    ) {
        String loginName = CookieUtils.getCookieValue(request, "token");
        if (isNotBlank(loginName)) {
            String loginNameJson = redisService.get(loginName);
            if (isNotBlank(loginNameJson)) {
                try {
                    String userInfoJson = redisService.get(loginNameJson);
                    if (isNotBlank(userInfoJson)) {
                        TbSysUser user = MapperUtils.json2pojo(userInfoJson, TbSysUser.class);
                        if (user != null) {
                            if (isNotBlank(url)) {
                                return "redirect:" + url;
                            }
                            model.addAttribute("userInfo", user);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (isNotBlank(url)) {
            model.addAttribute("url", url);
        }

        return "login";
    }

    /**
     * 登录
     *
     * @param url
     * @param userName
     * @param password
     * @param request
     * @param response
     * @param attributes
     * @return
     */
    @PostMapping("login")
    public String login(
            @RequestParam(required = false) String url,
            @RequestParam(required = true) String userName,
            @RequestParam(required = true) String password,
            HttpServletRequest request,
            HttpServletResponse response,
            RedirectAttributes attributes
    ) {
        TbSysUser info = service.login(userName, password);
        if (info == null) {
            attributes.addFlashAttribute("message", "用户名或密码错误！");
        } else {
            String token = UUID.randomUUID().toString();
            String redisResult = redisService.put(token, userName, 60 * 60 * 24);
            if (redisResult != null && redisResult.equals("ok")) {
                CookieUtils.setCookie(request, response, "token", token, 60 * 60 * 24);
                if (isNotBlank(url)) {
                    return "redirect:" + url;
                }
            } else {
                //连接的时候数据异常断开
                attributes.addFlashAttribute("message", "数据连接失败");
            }

        }
        return "redirect:/login";
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @GetMapping("loginOut")
    public String loginOut(
            @RequestParam(required = false) String url,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ) {

        try {
            CookieUtils.deleteCookie(request, response, "token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login(url, request, model);
    }

}
