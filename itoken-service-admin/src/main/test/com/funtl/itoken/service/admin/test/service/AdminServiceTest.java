package com.funtl.itoken.service.admin.test.service;

import com.funtl.itoken.service.admin.ServiceAdminApplication;
import com.funtl.itoken.service.admin.domain.TbSysUser;
import com.funtl.itoken.service.admin.mapper.TbSysUserMapper;
import com.funtl.itoken.service.admin.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =ServiceAdminApplication.class)
@ActiveProfiles(value = "prod")
@Transactional
@Rollback
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TbSysUserMapper sysUserMapper;
    /*注册
     */
    @Test
    public void testRegister() {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setLoginCode("lusifer@funtl.com");
        tbSysUser.setUserName("Lusifer");
        tbSysUser.setUserType("1");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateBy(tbSysUser.getUserCode());
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("0");
        tbSysUser.setCorpName("iToken");
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        sysUserMapper.insert(tbSysUser);
    }
}
