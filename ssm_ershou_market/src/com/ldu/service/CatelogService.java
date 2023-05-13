// 
// 
// 

package com.ldu.service;

import com.ldu.pojo.Catelog;
import java.util.List;

public interface CatelogService
{
    List<Catelog> getAllCatelog();
    
    int getCount(Catelog p0);
    
    Catelog selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKey(Catelog p0);
    
    int updateCatelogNum(Integer p0, Integer p1);
}
