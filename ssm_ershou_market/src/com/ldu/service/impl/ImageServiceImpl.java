// 
// 
// 

package com.ldu.service.impl;

import java.util.List;
import com.ldu.pojo.Image;
import javax.annotation.Resource;
import com.ldu.dao.ImageMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.ImageService;

@Service("imageService")
public class ImageServiceImpl implements ImageService
{
    @Resource
    private ImageMapper imageMapper;
    
    @Override
    public int insert(final Image record) {
        return this.imageMapper.insert(record);
    }
    
    @Override
    public List<Image> getImagesByGoodsPrimaryKey(final Integer goodsId) {
        final List<Image> image = this.imageMapper.selectByGoodsPrimaryKey(goodsId);
        return image;
    }
    
    @Override
    public int deleteImagesByGoodsPrimaryKey(final Integer goodsId) {
        return this.imageMapper.deleteImagesByGoodsPrimaryKey(goodsId);
    }
}
