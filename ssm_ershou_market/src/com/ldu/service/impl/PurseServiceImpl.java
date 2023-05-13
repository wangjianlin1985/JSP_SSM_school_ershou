// 
// 
// 

package com.ldu.service.impl;

import com.github.pagehelper.PageHelper;
import java.util.List;
import com.ldu.pojo.Purse;
import javax.annotation.Resource;
import com.ldu.dao.PurseMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.PurseService;

@Service("PurserService")
public class PurseServiceImpl implements PurseService
{
    @Resource
    private PurseMapper perseMapper;
    
    @Override
    public void updatePurseByuserId(final Integer userId, final Float balance) {
        this.perseMapper.updatePurseByuserId(userId, balance);
    }
    
    @Override
    public void updatePurseOfdel(final Integer userId, final Float balance) {
        this.perseMapper.updatePurseOfdel(userId, balance);
    }
    
    @Override
    public void addPurse(final Integer userId) {
        this.perseMapper.addPurse(userId);
    }
    
    @Override
    public Purse getPurseByUserId(final Integer user_id) {
        return this.perseMapper.selectPurseByUserId(user_id);
    }
    
    @Override
    public void updatePurse(final Purse purse) {
        this.perseMapper.updatePurse(purse);
    }
    
    @Override
    public int getPurseNum() {
        final List<Purse> purse = this.perseMapper.selectPurseList();
        return purse.size();
    }
    
    @Override
    public List<Purse> getPagePurse(final int pageNum, final int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<Purse> purse = this.perseMapper.selectPurseList();
        return purse;
    }
    
    @Override
    public List<Purse> getPagePurseByPurse(final Integer userId, final Integer state, final int pageNum, final int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<Purse> purse = this.perseMapper.getPagePurseByPurse(userId, state);
        return purse;
    }
    
    @Override
    public Purse getPurseById(final int id) {
        return this.perseMapper.selectPurseById(id);
    }
    
    @Override
    public void updateByPrimaryKey(final Integer id, final Purse purse) {
        purse.setId(id);
        this.perseMapper.updateByPrimaryKey(purse);
    }
    
    @Override
    public void updatePursePassById(final Integer id, final Purse purse) {
        purse.setId(id);
        this.perseMapper.updatePurseById(purse);
    }
    
    @Override
    public void updatePurseRefuseById(final Integer id, final Purse purse) {
        purse.setId(id);
        this.perseMapper.updatePurseById(purse);
    }
}
