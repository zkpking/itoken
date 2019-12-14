package com.kaider.itoken.service.admin.service.impl;

import com.kaider.itoken.service.admin.domain.TbSysUser;
import com.kaider.itoken.service.admin.mapper.TbSysUserMapper;
import com.kaider.itoken.service.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author： kaider
 * @Date：2019/12/15 00:48
 * @描述：
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private TbSysUserMapper mapper;


    @Override
    @Transactional(readOnly = false)
    public void register(TbSysUser info) {

    }

    @Override
    public TbSysUser login(String userName, String password) {
        return null;
    }
}
