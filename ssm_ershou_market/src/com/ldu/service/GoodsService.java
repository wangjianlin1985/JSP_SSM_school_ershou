// 
// 
// 

package com.ldu.service;

import com.ldu.pojo.Comments;
import com.ldu.pojo.CommentExtend;
import java.util.List;
import com.ldu.pojo.Goods;

public interface GoodsService
{
    int addGood(Goods p0, Integer p1);
    
    Goods getGoodsByPrimaryKey(Integer p0);
    
    Goods getGoodsById(Integer p0);
    
    void updateGoodsByPrimaryKeyWithBLOBs(int p0, Goods p1);
    
    void deleteGoodsByPrimaryKey(Integer p0);
    
    void deleteGoodsByPrimaryKeys(Integer p0);
    
    List<Goods> getAllGoods();
    
    List<Goods> searchGoods(String p0, String p1);
    
    List<Goods> getGoodsByStr(Integer p0, String p1, String p2);
    
    List<Goods> getGoodsByCatelog(Integer p0, String p1, String p2);
    
    List<Goods> getGoodsOrderByDate(Integer p0);
    
    List<Goods> getGoodsByCatelogOrderByDate(Integer p0, Integer p1);
    
    List<Goods> getGoodsByUserId(Integer p0);
    
    void updateGoodsByGoodsId(Goods p0);
    
    int getGoodsNum();
    
    List<Goods> getPageGoods(int p0, int p1);
    
    List<Goods> getPageGoodsByGoods(Integer p0, String p1, Integer p2, int p3, int p4);
    
    CommentExtend selectCommentsByGoodsId(Integer p0);
    
    void addComments(Comments p0);
}
