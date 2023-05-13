// 
// 
// 

package com.ldu.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodsExtend
{
    private Goods goods;
    private List<Image> images;
    private List<Comments> comments;
    
    public GoodsExtend() {
        this.images = new ArrayList<Image>();
        this.comments = new ArrayList<Comments>();
    }
    
    public Goods getGoods() {
        return this.goods;
    }
    
    public void setGoods(final Goods goods) {
        this.goods = goods;
    }
    
    public List<Image> getImages() {
        return this.images;
    }
    
    public void setImages(final List<Image> images) {
        this.images = images;
    }
    
    public List<Comments> getComments() {
        return this.comments;
    }
    
    public void setComments(final List<Comments> comments) {
        this.comments = comments;
    }
    
    @Override
    public String toString() {
        return "GoodsExtend [goods=" + this.goods + ", images=" + this.images + ", comments=" + this.comments + "]";
    }
}
