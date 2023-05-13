// 
// 
// 

package com.ldu.dao;

import com.ldu.pojo.Reply;

public interface ReplyMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Reply p0);
    
    int insertSelective(Reply p0);
    
    Reply selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Reply p0);
    
    int updateByPrimaryKeyWithBLOBs(Reply p0);
    
    int updateByPrimaryKey(Reply p0);
}
