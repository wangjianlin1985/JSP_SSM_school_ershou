// 
// 
// 

package com.ldu.service;

import com.ldu.pojo.Notice;
import java.util.List;

public interface NoticeService
{
    List<Notice> getNoticeList();
    
    void insertSelective(Notice p0);
}
