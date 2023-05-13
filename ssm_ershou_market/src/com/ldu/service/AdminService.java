// 
// 
// 

package com.ldu.service;

import com.ldu.pojo.Admin;

public interface AdminService
{
    Admin findAdmin(Long p0, String p1);
    
    Admin findAdminById(Integer p0);
    
    void updateAdmin(Admin p0);
}
