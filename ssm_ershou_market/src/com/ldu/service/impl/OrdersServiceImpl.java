// 
// 
// 

package com.ldu.service.impl;

import com.github.pagehelper.PageHelper;
import com.ldu.pojo.Orders;
import java.util.List;
import javax.annotation.Resource;
import com.ldu.dao.OrdersMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService
{
    @Resource
    private OrdersMapper ordersMapper;
    
    @Override
    public List<Orders> getOrdersByUserId(final Integer user_id) {
        final List<Orders> orders = this.ordersMapper.selectOrdersByUserId(user_id);
        return orders;
    }
    
    @Override
    public List<Orders> getOrdersByUserAndGoods(final Integer user_id) {
        final List<Orders> ordersOfSell = this.ordersMapper.selectOrdersByUserAndGoods(user_id);
        return ordersOfSell;
    }
    
    @Override
    public void addOrders(final Orders orders) {
        this.ordersMapper.addOrders(orders);
    }
    
    @Override
    public void deliverByOrderNum(final Integer orderNum) {
        this.ordersMapper.deliverByOrderNum(orderNum);
    }
    
    @Override
    public void receiptByOrderNum(final Integer orderNum) {
        this.ordersMapper.receiptByOrderNum(orderNum);
    }
    
    @Override
    public int getOrdersNum() {
        final List<Orders> orders = this.ordersMapper.getOrdersList();
        return orders.size();
    }
    
    @Override
    public List<Orders> getPageOrders(final int pageNum, final int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<Orders> list = this.ordersMapper.getOrdersList();
        return list;
    }
    
    @Override
    public Orders getOrdersById(final int ordersId) {
        final Orders orders = this.ordersMapper.selectById(ordersId);
        return orders;
    }
    
    @Override
    public void updateByPrimaryKey(final Integer id, final Orders orders) {
        orders.setId(id);
        this.ordersMapper.updateByPrimaryKey(orders);
    }
    
    @Override
    public void deleteOrdersByPrimaryKeys(final int id) {
        this.ordersMapper.deleteByPrimaryKeys(id);
    }
    
    @Override
    public List<Orders> getPageOrdersByOrders(final Long orderNum, final String orderInformation, final Integer orderState, final int pageNum, final int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<Orders> orders = this.ordersMapper.getPageOrdersByOrders(orderNum, orderInformation, orderState);
        return orders;
    }
}
