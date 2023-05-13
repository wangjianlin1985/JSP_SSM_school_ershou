// 
// 
// 

package com.ldu.service;

import java.util.List;
import com.ldu.pojo.Image;

public interface ImageService
{
    int insert(Image p0);
    
    List<Image> getImagesByGoodsPrimaryKey(Integer p0);
    
    int deleteImagesByGoodsPrimaryKey(Integer p0);
}
