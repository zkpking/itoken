package com.kaider.itoken.service.sso.service.impl;

import com.kaider.itoken.common.domain.TbSysUser;
import com.kaider.itoken.service.sso.mapper.TbSysUserMapper;
import com.kaider.itoken.service.sso.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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
    public TbSysUser login(String userName, String password) {
        Example example = new Example(TbSysUser.class);
        return mapper.selectOneByExample(example);
    }
}
