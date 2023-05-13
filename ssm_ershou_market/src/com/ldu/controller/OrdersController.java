// 
// 
// 

package com.ldu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import com.ldu.pojo.Goods;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.ldu.pojo.Purse;
import java.util.List;
import com.ldu.pojo.Orders;
import java.util.ArrayList;
import com.ldu.pojo.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.ldu.service.PurseService;
import com.ldu.service.GoodsService;
import javax.annotation.Resource;
import com.ldu.service.OrdersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/orders" })
public class OrdersController
{
    @Resource
    private OrdersService ordersService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private PurseService purseService;
    ModelAndView mv;
    
    public OrdersController() {
        this.mv = new ModelAndView();
    }
    
    @RequestMapping({ "/myOrders" })
    public ModelAndView orders(final HttpServletRequest request) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer user_id = cur_user.getId();
        List<Orders> ordersList1 = new ArrayList<Orders>();
        List<Orders> ordersList2 = new ArrayList<Orders>();
        ordersList1 = this.ordersService.getOrdersByUserId(user_id);
        ordersList2 = this.ordersService.getOrdersByUserAndGoods(user_id);
        final Purse myPurse = this.purseService.getPurseByUserId(user_id);
        this.mv.addObject("ordersOfSell", (Object)ordersList2);
        this.mv.addObject("orders", (Object)ordersList1);
        this.mv.addObject("myPurse", (Object)myPurse);
        this.mv.setViewName("/user/orders");
        return this.mv;
    }
    
    @RequestMapping({ "/addOrders" })
    public String addorders(final HttpServletRequest request, final Orders orders) {
        final Date d = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer user_id = cur_user.getId();
        orders.setUserId(user_id);
        orders.setOrderDate(sdf.format(d));
        final Goods goods = new Goods();
        goods.setStatus(0);
        goods.setId(orders.getGoodsId());
        this.goodsService.updateGoodsByGoodsId(goods);
        this.ordersService.addOrders(orders);
        final Float balance = orders.getOrderPrice();
        this.purseService.updatePurseOfdel(user_id, balance);
        return "redirect:/orders/myOrders";
    }
    
    @RequestMapping({ "/deliver/{orderNum}" })
    public String deliver(final HttpServletRequest request, @PathVariable("orderNum") final Integer orderNum) {
        this.ordersService.deliverByOrderNum(orderNum);
        return "redirect:/orders/myOrders";
    }
    
    @RequestMapping({ "/receipt" })
    public String receipt(final HttpServletRequest request) {
        final Integer orderNum = Integer.parseInt(request.getParameter("orderNum"));
        final Float balance = Float.parseFloat(request.getParameter("orderPrice"));
        final Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        final Integer userId = this.goodsService.getGoodsById(goodsId).getUserId();
        this.ordersService.receiptByOrderNum(orderNum);
        this.purseService.updatePurseByuserId(userId, balance);
        return "redirect:/orders/myOrders";
    }
}
