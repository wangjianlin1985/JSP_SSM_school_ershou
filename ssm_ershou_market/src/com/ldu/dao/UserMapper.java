// 
// 
// 

package com.ldu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ldu.pojo.User;

public interface UserMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(User p0);
    
    int insertSelective(User p0);
    
    User selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(User p0);
    
    int updateByPrimaryKey(User p0);
    
    User getUserByPhone(String p0);
    
    int updateGoodsNum(@Param("id") Integer p0, @Param("goodsNum") Integer p1);
    
    List<User> getUserList();
    
    int findCount();
    
    User getUserById(int p0);
    
    List<User> getUserListByUser(@Param("phone") String p0, @Param("username") String p1, @Param("qq") String p2);
    
    List<User> getUserListOrderByCreateAt();
}
