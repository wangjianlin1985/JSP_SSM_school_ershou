// 
// 
// 

package com.ldu.controller;

import com.ldu.pojo.Purse;
import com.ldu.util.PurseGrid;
import com.ldu.pojo.Orders;
import com.ldu.util.OrdersGrid;
import com.ldu.pojo.Goods;
import com.ldu.util.GoodsGrid;
import com.ldu.pojo.User;
import java.util.List;
import com.ldu.util.UserGrid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ldu.pojo.Admin;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import com.ldu.service.AdminService;
import com.ldu.service.PurseService;
import com.ldu.service.OrdersService;
import com.ldu.service.GoodsService;
import javax.annotation.Resource;
import com.ldu.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/admin" })
public class AdminController
{
    @Resource
    private UserService userService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private OrdersService ordersService;
    @Resource
    private PurseService purseService;
    @Resource
    private AdminService adminService;
    
    @RequestMapping(value = { "" }, method = { RequestMethod.GET })
    public String login(final HttpSession session) {
        session.invalidate();
        return "/admin/login";
    }
    
    @RequestMapping(value = { "/index" }, method = { RequestMethod.POST })
    public String index(final HttpServletRequest request, final Admin admins) {
        final Admin myadmin = this.adminService.findAdmin(admins.getPhone(), admins.getPassword());
        if (myadmin != null) {
            request.getSession().setAttribute("admin", (Object)myadmin);
            return "/admin/index";
        }
        return "/admin/login";
    }
    
    @RequestMapping({ "/indexs" })
    public String indexs(final HttpServletRequest request) {
        final Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            final Integer id = admin.getId();
            final Admin myadmin = this.adminService.findAdminById(id);
            request.getSession().setAttribute("admin", (Object)myadmin);
            return "/admin/index";
        }
        return "/admin/login";
    }
    
    @RequestMapping({ "/info" })
    @ResponseBody
    public ModelAndView getInfo(final HttpServletRequest request) {
        final Admin admin = (Admin)request.getSession().getAttribute("admin");
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin", (Object)admin);
        modelAndView.setViewName("admin/info");
        return modelAndView;
    }
    
    @RequestMapping({ "/modify" })
    @ResponseBody
    public ModelAndView getModify(final HttpServletRequest request) {
        final Admin admin = (Admin)request.getSession().getAttribute("admin");
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin", (Object)admin);
        modelAndView.setViewName("admin/modify");
        return modelAndView;
    }
    
    @RequestMapping({ "/changePassword" })
    @ResponseBody
    public ModelAndView changePassword(final HttpServletRequest request, final Admin admin) {
        final String pwd = request.getParameter("password1");
        final ModelAndView modelAndView = new ModelAndView();
        final Admin admins = (Admin)request.getSession().getAttribute("admin");
        if (admin.getPassword().equals(admins.getPassword())) {
            admins.setPassword(pwd);
            this.adminService.updateAdmin(admins);
            modelAndView.setViewName("admin/login");
            return modelAndView;
        }
        modelAndView.addObject("msg", (Object)"\u539f\u5bc6\u7801\u6709\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
        modelAndView.setViewName("admin/modify");
        return modelAndView;
    }
    
    @RequestMapping({ "/userList" })
    @ResponseBody
    public ModelAndView getUserList(@RequestParam("pageNum") final int pageNum) {
        final ModelAndView modelAndView = new ModelAndView();
        final int pageSize = 10;
        final int total = this.userService.getUserNum();
        final List<User> rows = this.userService.getPageUser(pageNum, pageSize);
        final UserGrid userGrid = new UserGrid();
        userGrid.setCurrent(pageNum);
        userGrid.setRowCount(pageSize);
        userGrid.setRows(rows);
        userGrid.setTotal(total);
        modelAndView.addObject("userGrid", (Object)userGrid);
        modelAndView.setViewName("admin/user/user_list");
        return modelAndView;
    }
    
    @RequestMapping({ "/getUser" })
    @ResponseBody
    public User getUser(final HttpServletRequest request) {
        final String id = request.getParameter("id");
        final User user = this.userService.getUserById(Integer.parseInt(id));
        return user;
    }
    
    @RequestMapping(value = { "/updateUser" }, method = { RequestMethod.POST })
    @ResponseBody
    public String updateUser(final HttpServletRequest request, final User user) {
        final User users = this.userService.selectByPrimaryKey(user.getId());
        user.setPassword(users.getPassword());
        try {
            this.userService.updateUserName(user);
        }
        catch (Exception e) {
            return "{\"success\":false,\"msg\":\"\u4fdd\u5b58\u5931\u8d25!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u4fdd\u5b58\u6210\u529f!\"}";
    }
    
    @RequestMapping(value = { "/deleteUser" }, method = { RequestMethod.POST })
    @ResponseBody
    public String deleteUser(final HttpServletRequest request, @RequestParam("ids[]") final String[] ids) {
        try {
            for (int i = 0; i < ids.length; ++i) {
                this.userService.deleteUserById(ids[i]);
            }
        }
        catch (Exception e) {
            return "{\"success\":false,\"msg\":\"\u5220\u9664\u5931\u8d25!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u5220\u9664\u6210\u529f!\"}";
    }
    
    @RequestMapping(value = { "/searchUser" }, method = { RequestMethod.POST })
    @ResponseBody
    public ModelAndView searchUser(final HttpServletRequest request, final User user) {
        final ModelAndView mv = new ModelAndView();
        final int pageNum = 1;
        final int pageSize = 10;
        final int total = this.userService.getUserNum();
        final String phone = user.getPhone();
        final String username = user.getUsername();
        final String qq = user.getQq();
        final List<User> rows = this.userService.getPageUserByUser(phone, username, qq, pageNum, pageSize);
        final UserGrid userGrid = new UserGrid();
        final User searchuser = new User();
        searchuser.setPhone(phone);
        searchuser.setUsername(username);
        searchuser.setQq(qq);
        userGrid.setCurrent(pageNum);
        userGrid.setRowCount(pageSize);
        userGrid.setRows(rows);
        userGrid.setTotal(total);
        mv.addObject("userGrid", (Object)userGrid);
        mv.addObject("searchuser", (Object)searchuser);
        mv.setViewName("admin/user/user_list");
        return mv;
    }
    
    @RequestMapping({ "/goodsList" })
    @ResponseBody
    public ModelAndView getGoodsList(@RequestParam("pageNum") final int pageNum) {
        final ModelAndView modelAndView = new ModelAndView();
        final int pageSize = 10;
        final int total = this.goodsService.getGoodsNum();
        final List<Goods> rows = this.goodsService.getPageGoods(pageNum, pageSize);
        final GoodsGrid goodsGrid = new GoodsGrid();
        goodsGrid.setCurrent(pageNum);
        goodsGrid.setRowCount(pageSize);
        goodsGrid.setRows(rows);
        goodsGrid.setTotal(total);
        modelAndView.addObject("goodsGrid", (Object)goodsGrid);
        modelAndView.setViewName("admin/goods/goods_list");
        return modelAndView;
    }
    
    @RequestMapping({ "/getGoods" })
    @ResponseBody
    public Goods getGoods(final HttpServletRequest request) {
        final String id = request.getParameter("id");
        final Goods goods = this.goodsService.getGoodsById(Integer.parseInt(id));
        return goods;
    }
    
    @RequestMapping(value = { "/updateGoods" }, method = { RequestMethod.POST })
    @ResponseBody
    public String updateGoods(final HttpServletRequest request, final Goods goods) {
        final int id = goods.getId();
        final Goods oldGoods = this.goodsService.getGoodsById(id);
        goods.setUserId(oldGoods.getUserId());
        goods.setPolishTime(oldGoods.getPolishTime());
        goods.setEndTime(oldGoods.getEndTime());
        try {
            this.goodsService.updateGoodsByPrimaryKeyWithBLOBs(goods.getId(), goods);
        }
        catch (Exception e) {
            return "{\"success\":false,\"msg\":\"\u4fdd\u5b58\u5931\u8d25!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u4fdd\u5b58\u6210\u529f!\"}";
    }
    
    @RequestMapping(value = { "/deleteGoods" }, method = { RequestMethod.POST })
    @ResponseBody
    public String deleteGoods(final HttpServletRequest request, @RequestParam("ids[]") final String[] ids) {
        try {
            for (int i = 0; i < ids.length; ++i) {
                this.goodsService.deleteGoodsByPrimaryKeys(Integer.parseInt(ids[i]));
            }
        }
        catch (Exception e) {
            return "{\"success\":false,\"msg\":\"\u5220\u9664\u5931\u8d25!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u5220\u9664\u6210\u529f!\"}";
    }
    
    @RequestMapping(value = { "/searchGoods" }, method = { RequestMethod.POST })
    @ResponseBody
    public ModelAndView searchGoods(final HttpServletRequest request, final Goods goods) {
        final ModelAndView mv = new ModelAndView();
        final int pageNum = 1;
        final int pageSize = 10;
        final int total = this.goodsService.getGoodsNum();
        final Integer id = goods.getId();
        final String name = goods.getName();
        final Integer status = goods.getStatus();
        final List<Goods> rows = this.goodsService.getPageGoodsByGoods(id, name, status, pageNum, pageSize);
        final GoodsGrid goodsGrid = new GoodsGrid();
        final Goods searchgoods = new Goods();
        searchgoods.setId(id);
        searchgoods.setName(name);
        searchgoods.setStatus(status);
        goodsGrid.setCurrent(pageNum);
        goodsGrid.setRowCount(pageSize);
        goodsGrid.setRows(rows);
        goodsGrid.setTotal(total);
        mv.addObject("goodsGrid", (Object)goodsGrid);
        mv.addObject("searchgoods", (Object)searchgoods);
        mv.setViewName("admin/goods/goods_list");
        return mv;
    }
    
    @RequestMapping({ "/ordersList" })
    @ResponseBody
    public ModelAndView getOrdersList(@RequestParam("pageNum") final int pageNum) {
        final ModelAndView modelAndView = new ModelAndView();
        final int pageSize = 10;
        final int total = this.ordersService.getOrdersNum();
        final List<Orders> rows = this.ordersService.getPageOrders(pageNum, pageSize);
        final OrdersGrid ordersGrid = new OrdersGrid();
        ordersGrid.setCurrent(pageNum);
        ordersGrid.setRowCount(pageSize);
        ordersGrid.setRows(rows);
        ordersGrid.setTotal(total);
        modelAndView.addObject("ordersGrid", (Object)ordersGrid);
        modelAndView.setViewName("admin/orders/orders_list");
        return modelAndView;
    }
    
    @RequestMapping({ "/getOrders" })
    @ResponseBody
    public Orders getOrders(final HttpServletRequest request) {
        final String id = request.getParameter("id");
        final Orders orders = this.ordersService.getOrdersById(Integer.parseInt(id));
        return orders;
    }
    
    @RequestMapping(value = { "/updateOrders" }, method = { RequestMethod.POST })
    @ResponseBody
    public String updateOrders(final HttpServletRequest request, final Orders orders) {
        final int id = orders.getId();
        final Orders oldorders = this.ordersService.getOrdersById(id);
        orders.setGoodsId(oldorders.getGoodsId());
        orders.setUserId(oldorders.getUserId());
        final Goods goods = this.goodsService.getGoodsById(oldorders.getGoods().getId());
        if (oldorders.getOrderState() != orders.getOrderState()) {
            final Float balance = orders.getOrderPrice();
            if (orders.getOrderState() == 3) {
                this.purseService.updatePurseByuserId(goods.getUserId(), balance);
            }
            else {
                this.purseService.updatePurseOfdel(goods.getUserId(), balance);
            }
        }
        try {
            this.ordersService.updateByPrimaryKey(id, orders);
        }
        catch (Exception e) {
            return "{\"success\":false,\"msg\":\"\u4fdd\u5b58\u5931\u8d25!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u4fdd\u5b58\u6210\u529f!\"}";
    }
    
    @RequestMapping(value = { "/deleteOrders" }, method = { RequestMethod.POST })
    @ResponseBody
    public String deleteOrders(final HttpServletRequest request, @RequestParam("ids[]") final String[] ids) {
        try {
            for (int i = 0; i < ids.length; ++i) {
                this.ordersService.deleteOrdersByPrimaryKeys(Integer.parseInt(ids[i]));
            }
        }
        catch (Exception e) {
            return "{\"success\":false,\"msg\":\"\u5220\u9664\u5931\u8d25!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u5220\u9664\u6210\u529f!\"}";
    }
    
    @RequestMapping(value = { "/searchOrders" }, method = { RequestMethod.POST })
    @ResponseBody
    public ModelAndView searchOrders(final HttpServletRequest request, final Orders orders) {
        final ModelAndView mv = new ModelAndView();
        final int pageNum = 1;
        final int pageSize = 10;
        final int total = this.ordersService.getOrdersNum();
        final Long orderNum = orders.getOrderNum();
        final String orderInformation = orders.getOrderInformation();
        final Integer orderState = orders.getOrderState();
        final List<Orders> rows = this.ordersService.getPageOrdersByOrders(orderNum, orderInformation, orderState, pageNum, pageSize);
        final OrdersGrid ordersGrid = new OrdersGrid();
        final Orders searchorders = new Orders();
        searchorders.setOrderNum(orderNum);
        searchorders.setOrderInformation(orderInformation);
        searchorders.setOrderState(orderState);
        ordersGrid.setCurrent(pageNum);
        ordersGrid.setRowCount(pageSize);
        ordersGrid.setRows(rows);
        ordersGrid.setTotal(total);
        mv.addObject("ordersGrid", (Object)ordersGrid);
        mv.addObject("searchorders", (Object)searchorders);
        mv.setViewName("admin/orders/orders_list");
        return mv;
    }
    
    @RequestMapping({ "/purseList" })
    @ResponseBody
    public ModelAndView getPurseList(final HttpServletRequest request) {
        final int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        final ModelAndView modelAndView = new ModelAndView();
        final int pageSize = 10;
        final int total = this.purseService.getPurseNum();
        final List<Purse> rows = this.purseService.getPagePurse(pageNum, pageSize);
        final PurseGrid purseGrid = new PurseGrid();
        purseGrid.setCurrent(pageNum);
        purseGrid.setRowCount(pageSize);
        purseGrid.setRows(rows);
        purseGrid.setTotal(total);
        modelAndView.addObject("purseGrid", (Object)purseGrid);
        modelAndView.setViewName("admin/purse/purse_list");
        return modelAndView;
    }
    
    @RequestMapping(value = { "/searchPurse" }, method = { RequestMethod.POST })
    @ResponseBody
    public ModelAndView searchPurse(final HttpServletRequest request, final Purse purse) {
        final ModelAndView mv = new ModelAndView();
        final int pageNum = 1;
        final int pageSize = 10;
        final int total = this.purseService.getPurseNum();
        final Integer userId = purse.getUserId();
        final Integer state = purse.getState();
        final List<Purse> rows = this.purseService.getPagePurseByPurse(userId, state, pageNum, pageSize);
        final PurseGrid purseGrid = new PurseGrid();
        final Purse searchpurse = new Purse();
        searchpurse.setUserId(userId);
        searchpurse.setState(state);
        purseGrid.setCurrent(pageNum);
        purseGrid.setRowCount(pageSize);
        purseGrid.setRows(rows);
        purseGrid.setTotal(total);
        mv.addObject("purseGrid", (Object)purseGrid);
        mv.addObject("searchpurse", (Object)searchpurse);
        mv.setViewName("admin/purse/purse_list");
        return mv;
    }
    
    @RequestMapping({ "/getPurse" })
    @ResponseBody
    public Purse getPurse(final HttpServletRequest request) {
        final String id = request.getParameter("id");
        final Purse purse = this.purseService.getPurseById(Integer.parseInt(id));
        return purse;
    }
    
    @RequestMapping(value = { "/updatePursePass" }, method = { RequestMethod.POST })
    @ResponseBody
    public String updatePursePass(final HttpServletRequest request, final Purse purse) {
        final Float balance = purse.getBalance();
        purse.setState(2);
        try {
            if (purse.getRecharge() != null) {
                final Float recharge = purse.getRecharge();
                final Float balanceRecharge = balance + recharge;
                purse.setBalance(balanceRecharge);
                this.purseService.updatePursePassById(purse.getId(), purse);
            }
            if (purse.getWithdrawals() != null) {
                final Float withdrawals = purse.getWithdrawals();
                final Float balanceWithdrawals = balance - withdrawals;
                purse.setBalance(balanceWithdrawals);
                this.purseService.updatePurseRefuseById(purse.getId(), purse);
            }
        }
        catch (Exception e) {
            return "{\"success\":true,\"msg\":\"\u5ba1\u6838\u5931\u8d25\uff0c\u8bf7\u6838\u5bf9\u91d1\u989d!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u5ba1\u6838\u6210\u529f!\"}";
    }
    
    @RequestMapping(value = { "/updatePurseRefuse" }, method = { RequestMethod.POST })
    @ResponseBody
    public String updatePurseRefuse(final HttpServletRequest request, final Purse purse) {
        purse.setState(1);
        try {
            this.purseService.updatePurseRefuseById(purse.getId(), purse);
        }
        catch (Exception e) {
            return "{\"success\":true,\"msg\":\"\u5ba1\u6838\u5931\u8d25!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u5ba1\u6838\u6210\u529f!\"}";
    }
    
    @RequestMapping(value = { "/updatePurseState" }, method = { RequestMethod.GET })
    public void updatePurseState(final HttpServletRequest request) {
        final Integer id = Integer.parseInt(request.getParameter("id"));
        final Purse purse = this.purseService.getPurseById(id);
        purse.setState(null);
        this.purseService.updateByPrimaryKey(id, purse);
    }
}
