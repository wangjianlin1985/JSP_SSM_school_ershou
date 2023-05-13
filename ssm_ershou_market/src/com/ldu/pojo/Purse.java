// 
// 
// 

package com.ldu.pojo;

public class Purse
{
    private Integer id;
    private Integer userId;
    private Float balance;
    private Float recharge;
    private Float withdrawals;
    private Integer state;
    
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
    
    public Float getBalance() {
        return this.balance;
    }
    
    public void setBalance(final Float balance) {
        this.balance = balance;
    }
    
    public Float getRecharge() {
        return this.recharge;
    }
    
    public void setRecharge(final Float recharge) {
        this.recharge = recharge;
    }
    
    public Float getWithdrawals() {
        return this.withdrawals;
    }
    
    public void setWithdrawals(final Float withdrawals) {
        this.withdrawals = withdrawals;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "Purse [id=" + this.id + ", userId=" + this.userId + ", balance=" + this.balance + ", recharge=" + this.recharge + ", withdrawals=" + this.withdrawals + ", state=" + this.state + "]";
    }
}
