// 
// 
// 

package com.ldu.dao;

import com.ldu.pojo.Admin;

public interface AdminMapper
{
    Admin findAdmin(Long p0, String p1);
    
    Admin findAdminById(Integer p0);
    
    void updateAdmin(Admin p0);
}
