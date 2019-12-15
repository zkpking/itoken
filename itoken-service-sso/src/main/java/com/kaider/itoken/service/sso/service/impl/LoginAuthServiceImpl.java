package com.kaider.itoken.service.sso.service.impl;

import com.kaider.itoken.common.domain.TbSysUser;
import com.kaider.itoken.common.utils.MapperUtils;
import com.kaider.itoken.service.sso.mapper.TbSysUserMapper;
import com.kaider.itoken.service.sso.service.ILoginAuthService;
import com.kaider.itoken.service.sso.service.consumer.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author： kaider
 * @Date：2019/12/15 00:48
 * @描述：
 */
@Service
@Transactional(readOnly = true)
public class LoginAuthServiceImpl implements ILoginAuthService {

    @Autowired
    private IRedisService redisService;
    @Autowired
    private TbSysUserMapper mapper;

    @Override
    public TbSysUser login(String userName, String password) {
        TbSysUser info = null;
        String loginTempJson = redisService.get(userName);
        if (loginTempJson == null) {//缓存中无数据
            Example example = new Example(TbSysUser.class);
            example.createCriteria()
                    .andEqualTo("loginCode", userName);
            info = mapper.selectOneByExample(example);
            String passwordTemp = DigestUtils.md5DigestAsHex(password.getBytes());
            if (info!=null && passwordTemp.equals(info.getPassword())) {
                try {
                    redisService.put(userName, MapperUtils.obj2json(info), 60 * 60 * 24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return info;
            } else {
                return null;
            }
        } else {//缓存中有数据
            try {
                info = MapperUtils.json2pojo(loginTempJson, TbSysUser.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return info;
    }
}
