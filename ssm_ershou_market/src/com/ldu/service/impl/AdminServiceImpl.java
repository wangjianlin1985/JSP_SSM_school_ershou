// 
// 
// 

package com.ldu.service.impl;

import com.ldu.pojo.Admin;
import javax.annotation.Resource;
import com.ldu.dao.AdminMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService
{
    @Resource
    private AdminMapper am;
    
    @Override
    public Admin findAdmin(final Long phone, final String password) {
        return this.am.findAdmin(phone, password);
    }
    
    @Override
    public Admin findAdminById(final Integer id) {
        return this.am.findAdminById(id);
    }
    
    @Override
    public void updateAdmin(final Admin admins) {
        this.am.updateAdmin(admins);
    }
}
