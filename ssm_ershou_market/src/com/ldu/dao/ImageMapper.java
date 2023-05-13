// 
// 
// 

package com.ldu.dao;

import java.util.List;
import com.ldu.pojo.Image;

public interface ImageMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int deleteImagesByGoodsPrimaryKey(Integer p0);
    
    int insert(Image p0);
    
    int insertSelective(Image p0);
    
    Image selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Image p0);
    
    int updateByPrimaryKeyWithBLOBs(Image p0);
    
    int updateByPrimaryKey(Image p0);
    
    List<Image> selectByGoodsPrimaryKey(Integer p0);
}
