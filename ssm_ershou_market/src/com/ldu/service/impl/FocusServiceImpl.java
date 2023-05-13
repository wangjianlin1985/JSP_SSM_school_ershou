// 
// 
// 

package com.ldu.service.impl;

import com.ldu.pojo.Focus;
import java.util.List;
import javax.annotation.Resource;
import com.ldu.dao.FocusMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.FocusService;

@Service("focusService")
public class FocusServiceImpl implements FocusService
{
    @Resource
    private FocusMapper focusMapper;
    
    @Override
    public List<Focus> getFocusByUserId(final Integer user_id) {
        final List<Focus> focusList = this.focusMapper.getFocusByUserId(user_id);
        return focusList;
    }
    
    @Override
    public void deleteFocusByUserIdAndGoodsId(final Integer goods_id, final Integer user_id) {
        this.focusMapper.deleteFocusByUserIdAndGoodsId(goods_id, user_id);
    }
    
    @Override
    public void addFocusByUserIdAndId(final Integer goods_id, final Integer user_id) {
        this.focusMapper.addFocusByUserIdAndGoodsId(goods_id, user_id);
    }
}
