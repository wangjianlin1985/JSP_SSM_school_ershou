// 
// 
// 

package com.ldu.pojo;

import java.util.List;

public class CommentExtend extends Goods
{
    private List<Comments> comments;
    
    public List<Comments> getComments() {
        return this.comments;
    }
    
    public void setComments(final List<Comments> comments) {
        this.comments = comments;
    }
}
