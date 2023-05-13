// 
// 
// 

package com.ldu.service;

import java.util.List;
import com.ldu.pojo.User;

public interface UserService
{
    void addUser(User p0);
    
    User getUserByPhone(String p0);
    
    void updateUserName(User p0);
    
    int updateGoodsNum(Integer p0, Integer p1);
    
    User selectByPrimaryKey(Integer p0);
    
    List<User> getPageUser(int p0, int p1);
    
    int getUserNum();
    
    int getUserNum(String p0);
    
    List<User> getPageUser(int p0, int p1, String p2);
    
    User getUserById(int p0);
    
    void deleteUserById(String p0);
    
    List<User> getPageUserByUser(String p0, String p1, String p2, int p3, int p4);
    
    List<User> getUserOrderByDate(int p0);
}
