package com.kaider.itoken.service.admin.service;

import com.kaider.itoken.service.admin.domain.TbSysUser;

/**
 * @Author： kaider
 * @Date：2019/12/15 00:46
 * @描述：
 */
public interface IAdminService {

    void register(TbSysUser info);

    TbSysUser login(String userName,String password);

}
