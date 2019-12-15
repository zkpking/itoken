package com.kaider.itoken.service.admin.controller;

import com.google.common.collect.Lists;
import com.kaider.itoken.common.dto.BaseResult;
import com.kaider.itoken.service.admin.domain.TbSysUser;
import com.kaider.itoken.service.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * @Author： kaider
 * @Date：2019/12/15 10:53
 * @描述：
 */
@RestController
public class ServiceAdminController {

    @Autowired
    private IAdminService service;

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    @GetMapping("login")
    public BaseResult login(
            String userName,
            String password
    ) {
        BaseResult baseResult = checkLogin(userName, password);
        if (baseResult != null) {
            return baseResult;
        }

        TbSysUser info = service.login(userName, password);

        if (info != null) {
            return BaseResult.ok(info);
        } else {
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("", "登录失败")));
        }
    }

    /**
     * 校验用户登录信息
     *
     * @param userName
     * @param password
     * @return
     */
    private BaseResult checkLogin(String userName, String password) {
        BaseResult baseResult = null;

        List<BaseResult.Error> errors = Lists.newArrayList();

        if (isBlank(userName) || isBlank(password)) {
            baseResult = BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("userName", "用户名为空"),
                    new BaseResult.Error("password", "密码为空")
            ));
        }
        baseResult.setErrors(errors);
        return baseResult;
    }

}
