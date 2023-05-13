// 
// 
// 

package com.ldu.util;

import com.ldu.pojo.Purse;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurseGrid
{
    private int current;
    private int rowCount;
    private int total;
    private List<Purse> rows;
    
    public int getCurrent() {
        return this.current;
    }
    
    public void setCurrent(final int current) {
        this.current = current;
    }
    
    public int getRowCount() {
        return this.rowCount;
    }
    
    public void setRowCount(final int rowCount) {
        this.rowCount = rowCount;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
    
    public List<Purse> getRows() {
        return this.rows;
    }
    
    public void setRows(final List<Purse> rows) {
        this.rows = rows;
    }
}
