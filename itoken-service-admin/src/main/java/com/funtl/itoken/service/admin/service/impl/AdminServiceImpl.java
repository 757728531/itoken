package com.funtl.itoken.service.admin.service.impl;

import com.funtl.itoken.service.admin.domain.TbSysUser;
import com.funtl.itoken.service.admin.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public void register(TbSysUser tbSysUser) {

    }

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {
        return null;
    }
}
