package com.kaider.itoken.web.admin.controller;

import com.kaider.itoken.web.admin.service.IWebAdminService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author： kaider
 * @Date：2019/12/15 13:27
 * @描述：
 */
@Controller
public class WebAdminController {

    @Autowired
    private IWebAdminService service;

    @GetMapping(value = {"","login"})
    public String say(
            String userName,
            String password
    ){
        String temp =service.login(userName,password);
        System.out.println(temp);
        return "index";
    }


}
