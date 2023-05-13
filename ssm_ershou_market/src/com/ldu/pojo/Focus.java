// 
// 
// 

package com.ldu.pojo;

public class Focus
{
    private Integer id;
    private Integer goodsId;
    private Integer userId;
    
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
    
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
    
    @Override
    public String toString() {
        return "Focus [id=" + this.id + ", goodsId=" + this.goodsId + ", userId=" + this.userId + "]";
    }
}
