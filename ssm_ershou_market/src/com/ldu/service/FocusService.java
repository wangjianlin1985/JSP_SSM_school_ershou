// 
// 
// 

package com.ldu.service;

import com.ldu.pojo.Focus;
import java.util.List;

public interface FocusService
{
    List<Focus> getFocusByUserId(Integer p0);
    
    void deleteFocusByUserIdAndGoodsId(Integer p0, Integer p1);
    
    void addFocusByUserIdAndId(Integer p0, Integer p1);
}
