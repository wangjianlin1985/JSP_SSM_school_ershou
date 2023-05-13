// 
// 
// 

package com.ldu.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.ldu.pojo.Purse;

public interface PurseMapper
{
    void updatePurseByuserId(Integer p0, Float p1);
    
    void updatePurseOfdel(Integer p0, Float p1);
    
    void addPurse(Integer p0);
    
    Purse selectPurseByUserId(Integer p0);
    
    void updatePurse(Purse p0);
    
    List<Purse> selectPurseList();
    
    List<Purse> getPagePurseByPurse(@Param("userId") Integer p0, @Param("state") Integer p1);
    
    Purse selectPurseById(int p0);
    
    void updateByPrimaryKey(Purse p0);
    
    void updatePurseById(Purse p0);
}
