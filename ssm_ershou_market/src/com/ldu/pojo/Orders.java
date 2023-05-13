// 
// 
// 

package com.ldu.pojo;

public class Orders
{
    private Integer id;
    private Integer userId;
    private Goods goods;
    private Integer goodsId;
    private Long orderNum;
    private Float orderPrice;
    private Integer orderState;
    private String orderInformation;
    private String orderDate;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
    
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
    
    public Long getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(final Long orderNum) {
        this.orderNum = orderNum;
    }
    
    public Float getOrderPrice() {
        return this.orderPrice;
    }
    
    public void setOrderPrice(final Float orderPrice) {
        this.orderPrice = orderPrice;
    }
    
    public Integer getOrderState() {
        return this.orderState;
    }
    
    public void setOrderState(final Integer orderState) {
        this.orderState = orderState;
    }
    
    public String getOrderInformation() {
        return this.orderInformation;
    }
    
    public void setOrderInformation(final String orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    public String getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(final String orderDate) {
        this.orderDate = orderDate;
    }
    
    @Override
    public String toString() {
        return "Orders [id=" + this.id + ", userId=" + this.userId + ", goods=" + this.goods + ", orderNum=" + this.orderNum + ", orderPrice=" + this.orderPrice + ", orderState=" + this.orderState + ", orderInformation=" + this.orderInformation + ", orderDate=" + this.orderDate + "]";
    }
}
