// 
// 
// 

package com.ldu.pojo;

public class Notice
{
    private Integer id;
    private String createAt;
    private Byte status;
    private String context;
    private User user;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getCreateAt() {
        return this.createAt;
    }
    
    public void setCreateAt(final String createAt) {
        this.createAt = createAt;
    }
    
    public Byte getStatus() {
        return this.status;
    }
    
    public void setStatus(final Byte status) {
        this.status = status;
    }
    
    public String getContext() {
        return this.context;
    }
    
    public void setContext(final String context) {
        this.context = context;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(final User user) {
        this.user = user;
    }
}
