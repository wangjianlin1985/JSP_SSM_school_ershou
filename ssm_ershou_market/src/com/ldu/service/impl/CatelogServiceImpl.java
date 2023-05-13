// 
// 
// 

package com.ldu.service.impl;

import java.util.List;
import com.ldu.pojo.Catelog;
import javax.annotation.Resource;
import com.ldu.dao.CatelogMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.CatelogService;

@Service("catelogService")
public class CatelogServiceImpl implements CatelogService
{
    @Resource
    private CatelogMapper catelogMapper;
    
    @Override
    public int getCount(final Catelog catelog) {
        final int count = this.catelogMapper.getCount(catelog);
        return count;
    }
    
    @Override
    public List<Catelog> getAllCatelog() {
        final List<Catelog> catelogs = this.catelogMapper.getAllCatelog();
        return catelogs;
    }
    
    @Override
    public Catelog selectByPrimaryKey(final Integer id) {
        final Catelog catelog = this.catelogMapper.selectByPrimaryKey(id);
        return catelog;
    }
    
    @Override
    public int updateByPrimaryKey(final Catelog catelog) {
        return this.catelogMapper.updateByPrimaryKey(catelog);
    }
    
    @Override
    public int updateCatelogNum(final Integer id, final Integer number) {
        return this.catelogMapper.updateCatelogNum(id, number);
    }
}
