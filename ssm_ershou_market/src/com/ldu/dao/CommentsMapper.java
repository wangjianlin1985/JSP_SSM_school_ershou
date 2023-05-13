// 
// 
// 

package com.ldu.dao;

import com.ldu.pojo.Comments;

public interface CommentsMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Comments p0);
    
    int insertSelective(Comments p0);
    
    Comments selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Comments p0);
    
    int updateByPrimaryKeyWithBLOBs(Comments p0);
    
    int updateByPrimaryKey(Comments p0);
}
