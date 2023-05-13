// 
// 
// 

package com.ldu.service.impl;

import com.ldu.pojo.Comments;
import com.ldu.pojo.CommentExtend;
import com.github.pagehelper.PageHelper;
import java.util.List;
import com.ldu.util.DateUtil;
import com.ldu.pojo.Goods;
import javax.annotation.Resource;
import com.ldu.dao.GoodsMapper;
import org.springframework.stereotype.Service;
import com.ldu.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService
{
    @Resource
    private GoodsMapper goodsMapper;
    
    @Override
    public int addGood(final Goods goods, final Integer duration) {
        final String startTime = DateUtil.getNowDay();
        final String endTime = DateUtil.getLastTime(startTime, duration);
        final String polishTime = startTime;
        goods.setPolishTime(polishTime);
        goods.setEndTime(endTime);
        goods.setStartTime(startTime);
        return this.goodsMapper.insert(goods);
    }
    
    @Override
    public Goods getGoodsByPrimaryKey(final Integer goodsId) {
        final Goods goods = this.goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }
    
    @Override
    public Goods getGoodsById(final Integer goodsId) {
        final Goods goods = this.goodsMapper.selectById(goodsId);
        return goods;
    }
    
    @Override
    public void deleteGoodsByPrimaryKey(final Integer id) {
        this.goodsMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void deleteGoodsByPrimaryKeys(final Integer id) {
        this.goodsMapper.deleteByPrimaryKeys(id);
    }
    
    @Override
    public List<Goods> getAllGoods() {
        final List<Goods> goods = this.goodsMapper.selectAllGoods();
        return goods;
    }
    
    @Override
    public List<Goods> searchGoods(final String name, final String describle) {
        final List<Goods> goods = this.goodsMapper.searchGoods(name, describle);
        return goods;
    }
    
    @Override
    public List<Goods> getGoodsByStr(final Integer limit, final String name, final String describle) {
        final List<Goods> goods = this.goodsMapper.selectByStr(limit, name, describle);
        return goods;
    }
    
    @Override
    public List<Goods> getGoodsByCatelog(final Integer id, final String name, final String describle) {
        final List<Goods> goods = this.goodsMapper.selectByCatelog(id, name, describle);
        return goods;
    }
    
    @Override
    public void updateGoodsByPrimaryKeyWithBLOBs(final int goodsId, final Goods goods) {
        goods.setId(goodsId);
        this.goodsMapper.updateByPrimaryKeyWithBLOBs(goods);
    }
    
    @Override
    public List<Goods> getGoodsByCatelogOrderByDate(final Integer catelogId, final Integer limit) {
        final List<Goods> goodsList = this.goodsMapper.selectByCatelogOrderByDate(catelogId, limit);
        return goodsList;
    }
    
    @Override
    public List<Goods> getGoodsOrderByDate(final Integer limit) {
        final List<Goods> goodsList = this.goodsMapper.selectOrderByDate(limit);
        return goodsList;
    }
    
    @Override
    public List<Goods> getGoodsByUserId(final Integer user_id) {
        final List<Goods> goodsList = this.goodsMapper.getGoodsByUserId(user_id);
        return goodsList;
    }
    
    @Override
    public void updateGoodsByGoodsId(final Goods goods) {
        this.goodsMapper.updateGoodsByGoodsId(goods);
    }
    
    @Override
    public int getGoodsNum() {
        final List<Goods> goods = this.goodsMapper.getGoodsList();
        return goods.size();
    }
    
    @Override
    public List<Goods> getPageGoods(final int pageNum, final int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<Goods> list = this.goodsMapper.getGoodsList();
        return list;
    }
    
    @Override
    public List<Goods> getPageGoodsByGoods(final Integer id, final String name, final Integer form, final int pageNum, final int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<Goods> list = this.goodsMapper.getPageGoodsByGoods(id, name, form);
        return list;
    }
    
    @Override
    public CommentExtend selectCommentsByGoodsId(final Integer id) {
        return this.goodsMapper.selectCommentsByGoodsId(id);
    }
    
    @Override
    public void addComments(final Comments comments) {
        this.goodsMapper.addComments(comments);
    }
}
