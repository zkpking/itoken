package com.kaider.itoken.service.admin.test.service;

import com.kaider.itoken.service.admin.ServiceAdminApplication;
import com.kaider.itoken.service.admin.domain.TbSysUser;
import com.kaider.itoken.service.admin.service.IAdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author： kaider
 * @Date：2019/12/15 00:35
 * @描述：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@Transactional
@Rollback
public class TbSysUserTest {

    @Autowired
    private IAdminService service;

    @Test
    public void register(){
        TbSysUser user = new TbSysUser();
        user.setLoginCode("admin");
        user.setPassword("123456");
        service.register(user);
    }

    @Test
    public void login(){
        TbSysUser user = service.login("admin","123456");
        Assert.assertNotNull(user);
    }



}
