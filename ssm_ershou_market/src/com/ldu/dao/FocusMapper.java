// 
// 
// 

package com.ldu.dao;

import com.ldu.pojo.Focus;
import java.util.List;

public interface FocusMapper
{
    List<Focus> getFocusByUserId(Integer p0);
    
    void deleteFocusByUserIdAndGoodsId(Integer p0, Integer p1);
    
    void addFocusByUserIdAndGoodsId(Integer p0, Integer p1);
}
