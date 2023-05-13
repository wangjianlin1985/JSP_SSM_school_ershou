// 
// 
// 

package com.ldu.pojo;

public class Image
{
    private Integer id;
    private Integer goodsId;
    private String imgUrl;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public Integer getGoodsId() {
        return this.goodsId;
    }
    
    public void setGoodsId(final Integer goodsId) {
        this.goodsId = goodsId;
    }
    
    public String getImgUrl() {
        return this.imgUrl;
    }
    
    public void setImgUrl(final String imgUrl) {
        this.imgUrl = ((imgUrl == null) ? null : imgUrl.trim());
    }
}
