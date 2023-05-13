// 
// 
// 

package com.ldu.pojo;

public class Admin
{
    private Integer id;
    private String userName;
    private Long phone;
    private String password;
    private String userRole;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public Long getPhone() {
        return this.phone;
    }
    
    public void setPhone(final Long phone) {
        this.phone = phone;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getUserRole() {
        return this.userRole;
    }
    
    public void setUserRole(final String userRole) {
        this.userRole = userRole;
    }
    
    @Override
    public String toString() {
        return "Admin [id=" + this.id + ", userName=" + this.userName + ", phone=" + this.phone + ", password=" + this.password + ", userRole=" + this.userRole + "]";
    }
}
