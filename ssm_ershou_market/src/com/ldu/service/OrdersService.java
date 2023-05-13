// 
// 
// 

package com.ldu.service;

import com.ldu.pojo.Orders;
import java.util.List;

public interface OrdersService
{
    List<Orders> getOrdersByUserId(Integer p0);
    
    List<Orders> getOrdersByUserAndGoods(Integer p0);
    
    void addOrders(Orders p0);
    
    void deliverByOrderNum(Integer p0);
    
    void receiptByOrderNum(Integer p0);
    
    int getOrdersNum();
    
    List<Orders> getPageOrders(int p0, int p1);
    
    Orders getOrdersById(int p0);
    
    void updateByPrimaryKey(Integer p0, Orders p1);
    
    void deleteOrdersByPrimaryKeys(int p0);
    
    List<Orders> getPageOrdersByOrders(Long p0, String p1, Integer p2, int p3, int p4);
}
