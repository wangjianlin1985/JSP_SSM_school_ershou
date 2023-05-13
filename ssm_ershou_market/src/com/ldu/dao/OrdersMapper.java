// 
// 
// 

package com.ldu.dao;

import org.apache.ibatis.annotations.Param;
import com.ldu.pojo.Orders;
import java.util.List;

public interface OrdersMapper
{
    List<Orders> selectOrdersByUserId(Integer p0);
    
    List<Orders> selectOrdersByUserAndGoods(Integer p0);
    
    void addOrders(Orders p0);
    
    void deliverByOrderNum(Integer p0);
    
    void receiptByOrderNum(Integer p0);
    
    List<Orders> getOrdersList();
    
    Orders selectById(int p0);
    
    void updateByPrimaryKey(Orders p0);
    
    void deleteByPrimaryKeys(int p0);
    
    List<Orders> getPageOrdersByOrders(@Param("orderNum") Long p0, @Param("orderInformation") String p1, @Param("orderState") Integer p2);
}
