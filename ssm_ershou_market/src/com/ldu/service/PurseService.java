// 
// 
// 

package com.ldu.service;

import java.util.List;
import com.ldu.pojo.Purse;

public interface PurseService
{
    void updatePurseByuserId(Integer p0, Float p1);
    
    void updatePurseOfdel(Integer p0, Float p1);
    
    void addPurse(Integer p0);
    
    Purse getPurseByUserId(Integer p0);
    
    void updatePurse(Purse p0);
    
    int getPurseNum();
    
    List<Purse> getPagePurse(int p0, int p1);
    
    List<Purse> getPagePurseByPurse(Integer p0, Integer p1, int p2, int p3);
    
    Purse getPurseById(int p0);
    
    void updateByPrimaryKey(Integer p0, Purse p1);
    
    void updatePursePassById(Integer p0, Purse p1);
    
    void updatePurseRefuseById(Integer p0, Purse p1);
}
