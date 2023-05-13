// 
// 
// 

package com.ldu.pojo;

public class Reply
{
    private Integer id;
    private Integer userId;
    private Integer atuserId;
    private Integer commetId;
    private String createAt;
    private String content;
    
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
    
    public Integer getAtuserId() {
        return this.atuserId;
    }
    
    public void setAtuserId(final Integer atuserId) {
        this.atuserId = atuserId;
    }
    
    public Integer getCommetId() {
        return this.commetId;
    }
    
    public void setCommetId(final Integer commetId) {
        this.commetId = commetId;
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
}
