// 
// 
// 

package com.ldu.pojo;

public class Goods
{
    private Integer id;
    private Integer catelogId;
    private Integer userId;
    private String name;
    private Float price;
    private Float realPrice;
    private String startTime;
    private String endTime;
    private String polishTime;
    private Integer status;
    private String describle;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public Integer getCatelogId() {
        return this.catelogId;
    }
    
    public void setCatelogId(final Integer catelogId) {
        this.catelogId = catelogId;
    }
    
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = ((name == null) ? null : name.trim());
    }
    
    public Float getPrice() {
        return this.price;
    }
    
    public void setPrice(final Float price) {
        this.price = price;
    }
    
    public Float getRealPrice() {
        return this.realPrice;
    }
    
    public void setRealPrice(final Float realPrice) {
        this.realPrice = realPrice;
    }
    
    public String getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(final String startTime) {
        this.startTime = ((startTime == null) ? null : startTime.trim());
    }
    
    public String getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(final String endTime) {
        this.endTime = ((endTime == null) ? null : endTime.trim());
    }
    
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(final Integer status) {
        this.status = status;
    }
    
    public String getDescrible() {
        return this.describle;
    }
    
    public void setDescrible(final String describle) {
        this.describle = ((describle == null) ? null : describle.trim());
    }
    
    public String getPolishTime() {
        return this.polishTime;
    }
    
    public void setPolishTime(final String polishTime) {
        this.polishTime = polishTime;
    }
    
    @Override
    public String toString() {
        return "Goods [id=" + this.id + ", catelogId=" + this.catelogId + ", userId=" + this.userId + ", name=" + this.name + ", price=" + this.price + ", realPrice=" + this.realPrice + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", polishTime=" + this.polishTime + ", status=" + this.status + ", describle=" + this.describle + "]";
    }
}
