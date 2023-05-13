// 
// 
// 

package com.ldu.service.impl;

import com.ldu.pojo.Notice;
import java.util.List;
import javax.annotation.Resource;
import com.ldu.dao.NoticeMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.NoticeService;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService
{
    @Resource
    private NoticeMapper noticeMapper;
    
    @Override
    public List<Notice> getNoticeList() {
        return this.noticeMapper.getNoticeList();
    }
    
    @Override
    public void insertSelective(final Notice notice) {
        this.noticeMapper.insertSelective(notice);
    }
}
