// 
// 
// 

package com.ldu.pojo;

public class Catelog
{
    private Integer id;
    private String name;
    private Integer number;
    private Byte status;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = ((name == null) ? null : name.trim());
    }
    
    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(final Integer number) {
        this.number = number;
    }
    
    public Byte getStatus() {
        return this.status;
    }
    
    public void setStatus(final Byte status) {
        this.status = status;
    }
}
