// 
// 
// 

package com.ldu.pojo;

public class Comments
{
    private Integer id;
    private User user;
    private String createAt;
    private Integer goodsId;
    private Goods goods;
    private String content;
    
    public Goods getGoods() {
        return this.goods;
    }
    
    public void setGoods(final Goods goods) {
        this.goods = goods;
    }
    
    public Integer getGoodsId() {
        return this.goodsId;
    }
    
    public void setGoodsId(final Integer goodsId) {
        this.goodsId = goodsId;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(final User user) {
        this.user = user;
    }
    
    public String getCreateAt() {
        return this.createAt;
    }
    
    public void setCreateAt(final String createAt) {
        this.createAt = ((createAt == null) ? null : createAt.trim());
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(final String content) {
        this.content = ((content == null) ? null : content.trim());
    }
    
    @Override
    public String toString() {
        return "Comments [id=" + this.id + ", user=" + this.user + ", createAt=" + this.createAt + ", goodsId=" + this.goodsId + ", goods=" + this.goods + ", content=" + this.content + "]";
    }
}
