// 
// 
// 

package com.ldu.dao;

import java.util.List;
import com.ldu.pojo.Notice;

public interface NoticeMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Notice p0);
    
    int insertSelective(Notice p0);
    
    Notice selectByPrimaryKey(Integer p0);
    
    List<Notice> getNoticeList();
    
    int updateByPrimaryKeySelective(Notice p0);
    
    int updateByPrimaryKeyWithBLOBs(Notice p0);
    
    int updateByPrimaryKey(Notice p0);
}
