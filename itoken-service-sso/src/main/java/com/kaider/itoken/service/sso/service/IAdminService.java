package com.kaider.itoken.service.sso.service;

import com.kaider.itoken.common.domain.TbSysUser;

/**
 * @Author： kaider
 * @Date：2019/12/15 00:46
 * @描述：
 */
public interface IAdminService {

    TbSysUser login(String userName, String password);

}
