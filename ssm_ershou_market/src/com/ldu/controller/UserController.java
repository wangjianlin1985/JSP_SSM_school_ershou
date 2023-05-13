// 
// 
// 

package com.ldu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.springframework.web.bind.annotation.PathVariable;
import com.ldu.pojo.Focus;
import com.ldu.pojo.Image;
import com.ldu.pojo.Goods;
import com.ldu.pojo.GoodsExtend;
import java.util.ArrayList;
import com.ldu.pojo.Notice;
import java.util.List;
import com.ldu.pojo.Purse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ldu.util.MD5;
import com.ldu.util.DateUtil;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.ldu.pojo.User;
import javax.servlet.http.HttpServletRequest;
import com.ldu.service.NoticeService;
import com.ldu.service.PurseService;
import com.ldu.service.FocusService;
import com.ldu.service.ImageService;
import com.ldu.service.GoodsService;
import javax.annotation.Resource;
import com.ldu.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/user" })
public class UserController
{
    @Resource
    private UserService userService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private ImageService imageService;
    @Resource
    private FocusService focusService;
    @Resource
    private PurseService purseService;
    @Resource
    private NoticeService noticeService;
    
    @RequestMapping({ "/addUser" })
    public String addUser(final HttpServletRequest request, @ModelAttribute("user") final User user1) {
        final String url = request.getHeader("Referer");
        final User user2 = this.userService.getUserByPhone(user1.getPhone());
        if (user2 == null) {
            final String t = DateUtil.getNowDate();
            final String str = MD5.md5(user1.getPassword());
            user1.setCreateAt(t);
            user1.setPassword(str);
            user1.setGoodsNum(0);
            user1.setStatus((byte)1);
            user1.setPower(100);
            this.userService.addUser(user1);
            this.purseService.addPurse(user1.getId());
        }
        return "redirect:" + url;
    }
    
    @RequestMapping(value = { "/register" }, method = { RequestMethod.POST })
    @ResponseBody
    public String register(final HttpServletRequest request) {
        final String phone = request.getParameter("phone");
        final User user = this.userService.getUserByPhone(phone);
        if (user == null) {
            return "{\"success\":true,\"flag\":false}";
        }
        return "{\"success\":true,\"flag\":true}";
    }
    
    @RequestMapping({ "/login" })
    public ModelAndView loginValidate(final HttpServletRequest request, final HttpServletResponse response, final User user, final ModelMap modelMap) {
        final User cur_user = this.userService.getUserByPhone(user.getPhone());
        final String url = request.getHeader("Referer");
        if (cur_user != null) {
            final String pwd = MD5.md5(user.getPassword());
            if (pwd.equals(cur_user.getPassword()) && cur_user.getStatus() == 1) {
                request.getSession().setAttribute("cur_user", (Object)cur_user);
                return new ModelAndView("redirect:" + url);
            }
        }
        return new ModelAndView("redirect:" + url);
    }
    
    @RequestMapping({ "/changeName" })
    public ModelAndView changeName(final HttpServletRequest request, final User user, final ModelMap modelMap) {
        final String url = request.getHeader("Referer");
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        cur_user.setUsername(user.getUsername());
        this.userService.updateUserName(cur_user);
        request.getSession().setAttribute("cur_user", (Object)cur_user);
        return new ModelAndView("redirect:" + url);
    }
    
    @RequestMapping({ "/updateInfo" })
    public ModelAndView updateInfo(final HttpServletRequest request, final User user, final ModelMap modelMap) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        cur_user.setUsername(user.getUsername());
        cur_user.setQq(user.getQq());
        this.userService.updateUserName(cur_user);
        request.getSession().setAttribute("cur_user", (Object)cur_user);
        return new ModelAndView("redirect:/user/basic");
    }
    
    @RequestMapping({ "/logout" })
    public String logout(final HttpServletRequest request) {
        request.getSession().setAttribute("cur_user", (Object)null);
        return "redirect:/goods/homeGoods";
    }
    
    @RequestMapping({ "/home" })
    public ModelAndView home(final HttpServletRequest request) {
        final ModelAndView mv = new ModelAndView();
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer userId = cur_user.getId();
        final int size = 5;
        final Purse myPurse = this.purseService.getPurseByUserId(userId);
        final List<User> users = this.userService.getUserOrderByDate(size);
        final List<Notice> notice = this.noticeService.getNoticeList();
        mv.addObject("notice", (Object)notice);
        mv.addObject("myPurse", (Object)myPurse);
        mv.addObject("users", (Object)users);
        mv.setViewName("/user/home");
        return mv;
    }
    
    @RequestMapping({ "/basic" })
    public ModelAndView basic(final HttpServletRequest request) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer userId = cur_user.getId();
        final Purse myPurse = this.purseService.getPurseByUserId(userId);
        final ModelAndView mv = new ModelAndView();
        mv.addObject("myPurse", (Object)myPurse);
        mv.setViewName("/user/basic");
        return mv;
    }
    
    @RequestMapping({ "/allGoods" })
    public ModelAndView goods(final HttpServletRequest request) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer userId = cur_user.getId();
        final List<Goods> goodsList = this.goodsService.getGoodsByUserId(userId);
        final List<GoodsExtend> goodsAndImage = new ArrayList<GoodsExtend>();
        for (int i = 0; i < goodsList.size(); ++i) {
            final GoodsExtend goodsExtend = new GoodsExtend();
            final Goods goods = goodsList.get(i);
            final List<Image> images = this.imageService.getImagesByGoodsPrimaryKey(goods.getId());
            goodsExtend.setGoods(goods);
            goodsExtend.setImages(images);
            goodsAndImage.add(i, goodsExtend);
        }
        final Purse myPurse = this.purseService.getPurseByUserId(userId);
        final ModelAndView mv = new ModelAndView();
        mv.addObject("goodsAndImage", (Object)goodsAndImage);
        mv.setViewName("/user/goods");
        mv.addObject("myPurse", (Object)myPurse);
        return mv;
    }
    
    @RequestMapping({ "/allFocus" })
    public ModelAndView focus(final HttpServletRequest request) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer userId = cur_user.getId();
        final List<Focus> focusList = this.focusService.getFocusByUserId(userId);
        final List<GoodsExtend> goodsAndImage = new ArrayList<GoodsExtend>();
        for (int i = 0; i < focusList.size(); ++i) {
            final GoodsExtend goodsExtend = new GoodsExtend();
            final Focus focus = focusList.get(i);
            final Goods goods = this.goodsService.getGoodsByPrimaryKey(focus.getGoodsId());
            final List<Image> images = this.imageService.getImagesByGoodsPrimaryKey(focus.getGoodsId());
            goodsExtend.setGoods(goods);
            goodsExtend.setImages(images);
            goodsAndImage.add(i, goodsExtend);
        }
        final Purse myPurse = this.purseService.getPurseByUserId(userId);
        final ModelAndView mv = new ModelAndView();
        mv.addObject("goodsAndImage", (Object)goodsAndImage);
        mv.addObject("myPurse", (Object)myPurse);
        mv.setViewName("/user/focus");
        return mv;
    }
    
    @RequestMapping({ "/deleteFocus/{id}" })
    public String deleteFocus(final HttpServletRequest request, @PathVariable("id") final Integer goods_id) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer user_id = cur_user.getId();
        this.focusService.deleteFocusByUserIdAndGoodsId(goods_id, user_id);
        return "redirect:/user/allFocus";
    }
    
    @RequestMapping({ "/addFocus/{id}" })
    public String addFocus(final HttpServletRequest request, @PathVariable("id") final Integer goods_id) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer user_id = cur_user.getId();
        final List<Focus> focus = this.focusService.getFocusByUserId(user_id);
        if (focus.isEmpty()) {
            this.focusService.addFocusByUserIdAndId(goods_id, user_id);
        }
        for (final Focus myfocus : focus) {
            final int goodsId = myfocus.getGoodsId();
            if (goodsId != goods_id) {
                this.focusService.addFocusByUserIdAndId(goods_id, user_id);
            }
        }
        return "redirect:/user/allFocus";
    }
    
    @RequestMapping({ "/myPurse" })
    public ModelAndView getMoney(final HttpServletRequest request) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer user_id = cur_user.getId();
        final Purse purse = this.purseService.getPurseByUserId(user_id);
        final ModelAndView mv = new ModelAndView();
        mv.addObject("myPurse", (Object)purse);
        mv.setViewName("/user/purse");
        return mv;
    }
    
    @RequestMapping({ "/updatePurse" })
    public String updatePurse(final HttpServletRequest request, final Purse purse) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer user_id = cur_user.getId();
        purse.setUserId(user_id);
        purse.setState(0);
        if (purse.getRecharge() != null) {
            this.purseService.updatePurse(purse);
        }
        if (purse.getWithdrawals() != null) {
            this.purseService.updatePurse(purse);
        }
        return "redirect:/user/myPurse";
    }
    
    @RequestMapping(value = { "/insertSelective" }, method = { RequestMethod.POST })
    @ResponseBody
    public String insertSelective(final HttpServletRequest request) {
        final String context = request.getParameter("context");
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Notice notice = new Notice();
        notice.setContext(context);
        final Date dt = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        notice.setCreateAt(sdf.format(dt));
        notice.setStatus((byte)0);
        notice.setUser(cur_user);
        if (context == null || context == "") {
            return "{\"success\":false,\"msg\":\"\u53d1\u5e03\u5931\u8d25\uff0c\u8bf7\u8f93\u5165\u5185\u5bb9!\"}";
        }
        try {
            this.noticeService.insertSelective(notice);
        }
        catch (Exception e) {
            return "{\"success\":false,\"msg\":\"\u53d1\u5e03\u5931\u8d25!\"}";
        }
        return "{\"success\":true,\"msg\":\"\u53d1\u5e03\u6210\u529f!\"}";
    }
}
