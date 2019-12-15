package com.kaider.itoken.web.admin.controller;

import com.kaider.itoken.web.admin.service.IWebAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author： kaider
 * @Date：2019/12/15 13:27
 * @描述：
 */
@Controller
public class WebAdminController {

    @Autowired
    private IWebAdminService adminService;

    @GetMapping(value = {"", "login"})
    public String login() {
        return "index";
    }

}
