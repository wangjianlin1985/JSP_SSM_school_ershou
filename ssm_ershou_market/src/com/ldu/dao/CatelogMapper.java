// 
// 
// 

package com.ldu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ldu.pojo.Catelog;

public interface CatelogMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Catelog p0);
    
    int insertSelective(Catelog p0);
    
    Catelog selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Catelog p0);
    
    int updateByPrimaryKey(Catelog p0);
    
    int updateCatelogNum(@Param("id") Integer p0, @Param("number") Integer p1);
    
    List<Catelog> getAllCatelog();
    
    int getCount(Catelog p0);
}
