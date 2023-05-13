// 
// 
// 

package com.ldu.pojo;

public class User
{
    private Integer id;
    private String phone;
    private String username;
    private String password;
    private String qq;
    private String createAt;
    private Integer goodsNum;
    private Integer power;
    private String lastLogin;
    private Byte status;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = ((phone == null) ? null : phone.trim());
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = ((username == null) ? null : username.trim());
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = ((password == null) ? null : password.trim());
    }
    
    public String getQq() {
        return this.qq;
    }
    
    public void setQq(final String qq) {
        this.qq = ((qq == null) ? null : qq.trim());
    }
    
    public String getCreateAt() {
        return this.createAt;
    }
    
    public void setCreateAt(final String createAt) {
        this.createAt = ((createAt == null) ? null : createAt.trim());
    }
    
    public Integer getGoodsNum() {
        return this.goodsNum;
    }
    
    public void setGoodsNum(final Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
    
    public Integer getPower() {
        return this.power;
    }
    
    public void setPower(final Integer power) {
        this.power = power;
    }
    
    public String getLastLogin() {
        return this.lastLogin;
    }
    
    public void setLastLogin(final String lastLogin) {
        this.lastLogin = ((lastLogin == null) ? null : lastLogin.trim());
    }
    
    public Byte getStatus() {
        return this.status;
    }
    
    public void setStatus(final Byte status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "User [id=" + this.id + ", phone=" + this.phone + ", username=" + this.username + ", password=" + this.password + ", qq=" + this.qq + ", createAt=" + this.createAt + ", goodsNum=" + this.goodsNum + ", power=" + this.power + ", lastLogin=" + this.lastLogin + ", status=" + this.status + "]";
    }
}
