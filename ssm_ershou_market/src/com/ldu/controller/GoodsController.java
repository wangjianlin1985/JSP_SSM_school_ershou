// 
// 
// 

package com.ldu.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.HashMap;
import java.io.File;
import java.util.UUID;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import com.ldu.util.DateUtil;
import com.ldu.pojo.Purse;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.ldu.pojo.Comments;
import com.ldu.pojo.CommentExtend;
import com.ldu.pojo.User;
import com.ldu.pojo.Catelog;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import com.ldu.pojo.Image;
import java.util.List;
import com.ldu.pojo.Goods;
import com.ldu.pojo.GoodsExtend;
import java.util.ArrayList;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import com.ldu.service.PurseService;
import com.ldu.service.UserService;
import com.ldu.service.CatelogService;
import com.ldu.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ldu.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/goods" })
public class GoodsController
{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CatelogService catelogService;
    @Autowired
    private UserService userService;
    @Resource
    private PurseService purseService;
    
    @RequestMapping({ "/homeGoods" })
    public ModelAndView homeGoods() throws Exception {
        final ModelAndView modelAndView = new ModelAndView();
        final int catelogSize = 7;
        final int goodsSize = 6;
        List<Goods> goodsList = null;
        List<GoodsExtend> goodsAndImage = null;
        goodsList = this.goodsService.getGoodsOrderByDate(goodsSize);
        goodsAndImage = new ArrayList<GoodsExtend>();
        for (int j = 0; j < goodsList.size(); ++j) {
            final GoodsExtend goodsExtend = new GoodsExtend();
            final Goods goods = goodsList.get(j);
            final List<Image> images = this.imageService.getImagesByGoodsPrimaryKey(goods.getId());
            goodsExtend.setGoods(goods);
            goodsExtend.setImages(images);
            goodsAndImage.add(j, goodsExtend);
        }
        final String key0 = "catelogGoods";
        modelAndView.addObject(key0, (Object)goodsAndImage);
        for (int i = 1; i <= catelogSize; ++i) {
            goodsList = this.goodsService.getGoodsByCatelogOrderByDate(i, goodsSize);
            goodsAndImage = new ArrayList<GoodsExtend>();
            for (int k = 0; k < goodsList.size(); ++k) {
                final GoodsExtend goodsExtend2 = new GoodsExtend();
                final Goods goods2 = goodsList.get(k);
                final List<Image> images2 = this.imageService.getImagesByGoodsPrimaryKey(goods2.getId());
                goodsExtend2.setGoods(goods2);
                goodsExtend2.setImages(images2);
                goodsAndImage.add(k, goodsExtend2);
            }
            final String key = "catelogGoods" + i;
            modelAndView.addObject(key, (Object)goodsAndImage);
        }
        modelAndView.setViewName("goods/homeGoods");
        return modelAndView;
    }
    
    @RequestMapping({ "/search" })
    public ModelAndView searchGoods(@RequestParam(value = "str", required = false) final String str) throws Exception {
        final List<Goods> goodsList = this.goodsService.searchGoods(str, str);
        final List<GoodsExtend> goodsExtendList = new ArrayList<GoodsExtend>();
        for (int i = 0; i < goodsList.size(); ++i) {
            final GoodsExtend goodsExtend = new GoodsExtend();
            final Goods goods = goodsList.get(i);
            final List<Image> imageList = this.imageService.getImagesByGoodsPrimaryKey(goods.getId());
            goodsExtend.setGoods(goods);
            goodsExtend.setImages(imageList);
            goodsExtendList.add(i, goodsExtend);
        }
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goodsExtendList", (Object)goodsExtendList);
        modelAndView.addObject("search", (Object)str);
        modelAndView.setViewName("/goods/searchGoods");
        return modelAndView;
    }
    
    @RequestMapping({ "/catelog" })
    public ModelAndView homeGoods(final HttpServletRequest request, @RequestParam(value = "str", required = false) final String str) throws Exception {
        final ModelAndView modelAndView = new ModelAndView();
        final int goodsSize = 12;
        List<Goods> goodsList = null;
        List<GoodsExtend> goodsAndImage = null;
        goodsList = this.goodsService.getGoodsByStr(goodsSize, str, str);
        goodsAndImage = new ArrayList<GoodsExtend>();
        for (int j = 0; j < goodsList.size(); ++j) {
            final GoodsExtend goodsExtend = new GoodsExtend();
            final Goods goods = goodsList.get(j);
            final List<Image> images = this.imageService.getImagesByGoodsPrimaryKey(goods.getId());
            goodsExtend.setGoods(goods);
            goodsExtend.setImages(images);
            goodsAndImage.add(j, goodsExtend);
        }
        modelAndView.addObject("goodsExtendList", (Object)goodsAndImage);
        modelAndView.addObject("search", (Object)str);
        modelAndView.setViewName("/goods/catelogGoods");
        return modelAndView;
    }
    
    @RequestMapping({ "/catelog/{id}" })
    public ModelAndView catelogGoods(final HttpServletRequest request, @PathVariable("id") final Integer id, @RequestParam(value = "str", required = false) final String str) throws Exception {
        final List<Goods> goodsList = this.goodsService.getGoodsByCatelog(id, str, str);
        final Catelog catelog = this.catelogService.selectByPrimaryKey(id);
        final List<GoodsExtend> goodsExtendList = new ArrayList<GoodsExtend>();
        for (int i = 0; i < goodsList.size(); ++i) {
            final GoodsExtend goodsExtend = new GoodsExtend();
            final Goods goods = goodsList.get(i);
            final List<Image> imageList = this.imageService.getImagesByGoodsPrimaryKey(goods.getId());
            goodsExtend.setGoods(goods);
            goodsExtend.setImages(imageList);
            goodsExtendList.add(i, goodsExtend);
        }
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goodsExtendList", (Object)goodsExtendList);
        modelAndView.addObject("catelog", (Object)catelog);
        modelAndView.addObject("search", (Object)str);
        modelAndView.setViewName("/goods/catelogGoods");
        return modelAndView;
    }
    
    @RequestMapping({ "/goodsId/{id}" })
    public ModelAndView getGoodsById(final HttpServletRequest request, @PathVariable("id") final Integer id, @RequestParam(value = "str", required = false) final String str) throws Exception {
        final Goods goods = this.goodsService.getGoodsByPrimaryKey(id);
        final User seller = this.userService.selectByPrimaryKey(goods.getUserId());
        final Catelog catelog = this.catelogService.selectByPrimaryKey(goods.getCatelogId());
        final GoodsExtend goodsExtend = new GoodsExtend();
        final List<Image> imageList = this.imageService.getImagesByGoodsPrimaryKey(id);
        final CommentExtend CommentExtend = this.goodsService.selectCommentsByGoodsId(id);
        goodsExtend.setGoods(goods);
        goodsExtend.setImages(imageList);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("CommentExtend", (Object)CommentExtend);
        modelAndView.addObject("goodsExtend", (Object)goodsExtend);
        modelAndView.addObject("seller", (Object)seller);
        modelAndView.addObject("search", (Object)str);
        modelAndView.addObject("catelog", (Object)catelog);
        modelAndView.setViewName("/goods/detailGoods");
        return modelAndView;
    }
    
    @RequestMapping(value = { "/addComments" }, method = { RequestMethod.POST })
    public void deleteFocus(final HttpServletRequest request, final Comments comments) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        comments.setUser(cur_user);
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        final Date createAt = new Date();
        comments.setCreateAt(sdf.format(createAt));
        this.goodsService.addComments(comments);
    }
    
    @RequestMapping({ "/editGoods/{id}" })
    public ModelAndView editGoods(final HttpServletRequest request, @PathVariable("id") final Integer id) throws Exception {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Goods goods = this.goodsService.getGoodsByPrimaryKey(id);
        final List<Image> imageList = this.imageService.getImagesByGoodsPrimaryKey(id);
        final GoodsExtend goodsExtend = new GoodsExtend();
        goodsExtend.setGoods(goods);
        goodsExtend.setImages(imageList);
        final ModelAndView modelAndView = new ModelAndView();
        final Integer userId = cur_user.getId();
        final Purse myPurse = this.purseService.getPurseByUserId(userId);
        modelAndView.addObject("myPurse", (Object)myPurse);
        modelAndView.addObject("goodsExtend", (Object)goodsExtend);
        modelAndView.setViewName("/goods/editGoods");
        return modelAndView;
    }
    
    @RequestMapping({ "/editGoodsSubmit" })
    public String editGoodsSubmit(final HttpServletRequest request, final Goods goods) throws Exception {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        goods.setUserId(cur_user.getId());
        final String polish_time = DateUtil.getNowDay();
        goods.setPolishTime(polish_time);
        goods.setStatus(1);
        this.goodsService.updateGoodsByPrimaryKeyWithBLOBs(goods.getId(), goods);
        return "redirect:/user/allGoods";
    }
    
    @RequestMapping({ "/offGoods" })
    public ModelAndView offGoods() throws Exception {
        return null;
    }
    
    @RequestMapping({ "/deleteGoods/{id}" })
    public String deleteGoods(final HttpServletRequest request, @PathVariable("id") final Integer id) throws Exception {
        final Goods goods = this.goodsService.getGoodsByPrimaryKey(id);
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        goods.setUserId(cur_user.getId());
        final int number = cur_user.getGoodsNum();
        final Integer calelog_id = goods.getCatelogId();
        final Catelog catelog = this.catelogService.selectByPrimaryKey(calelog_id);
        this.catelogService.updateCatelogNum(calelog_id, catelog.getNumber() - 1);
        this.userService.updateGoodsNum(cur_user.getId(), number - 1);
        cur_user.setGoodsNum(number - 1);
        request.getSession().setAttribute("cur_user", (Object)cur_user);
        this.goodsService.deleteGoodsByPrimaryKey(id);
        return "redirect:/user/allGoods";
    }
    
    @RequestMapping({ "/publishGoods" })
    public ModelAndView publishGoods(final HttpServletRequest request) {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer userId = cur_user.getId();
        final Purse myPurse = this.purseService.getPurseByUserId(userId);
        final ModelAndView mv = new ModelAndView();
        mv.addObject("myPurse", (Object)myPurse);
        mv.setViewName("/goods/pubGoods");
        return mv;
    }
    
    @RequestMapping({ "/publishGoodsSubmit" })
    public String publishGoodsSubmit(final HttpServletRequest request, final Image ima, final Goods goods, final MultipartFile image) throws Exception {
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        goods.setUserId(cur_user.getId());
        this.goodsService.addGood(goods, 10);
        final int goodsId = goods.getId();
        ima.setGoodsId(goodsId);
        this.imageService.insert(ima);
        final int number = cur_user.getGoodsNum();
        final Integer calelog_id = goods.getCatelogId();
        final Catelog catelog = this.catelogService.selectByPrimaryKey(calelog_id);
        this.catelogService.updateCatelogNum(calelog_id, catelog.getNumber() + 1);
        this.userService.updateGoodsNum(cur_user.getId(), number + 1);
        cur_user.setGoodsNum(number + 1);
        request.getSession().setAttribute("cur_user", (Object)cur_user);
        return "redirect:/user/allGoods";
    }
    
    @ResponseBody
    @RequestMapping({ "/uploadFile" })
    public Map<String, Object> uploadFile(final HttpSession session, final MultipartFile myfile) throws IllegalStateException, IOException {
        final String oldFileName = myfile.getOriginalFilename();
        final String file_path = session.getServletContext().getRealPath("upload");
        if (myfile != null && oldFileName != null && oldFileName.length() > 0) {
            final String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
            final File newFile = new File(String.valueOf(file_path) + "/" + newFileName);
            myfile.transferTo(newFile);
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "\u6210\u529f\u5566");
            map.put("imgUrl", newFileName);
            return map;
        }
        final Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("error", "\u56fe\u7247\u4e0d\u5408\u6cd5");
        return map2;
    }
    
    @RequestMapping({ "/buyId/{id}" })
    public ModelAndView getGoodsdetailById(final HttpServletRequest request, @PathVariable("id") final Integer id) throws Exception {
        final Goods goods = this.goodsService.getGoodsByPrimaryKey(id);
        final GoodsExtend goodsExtend = new GoodsExtend();
        final List<Image> imageList = this.imageService.getImagesByGoodsPrimaryKey(id);
        goodsExtend.setGoods(goods);
        goodsExtend.setImages(imageList);
        final User cur_user = (User)request.getSession().getAttribute("cur_user");
        final Integer userId = cur_user.getId();
        final Purse myPurse = this.purseService.getPurseByUserId(userId);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goodsExtend", (Object)goodsExtend);
        modelAndView.addObject("myPurse", (Object)myPurse);
        modelAndView.setViewName("/user/pay");
        return modelAndView;
    }
}
