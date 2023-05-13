// 
// 
// 

package com.ldu.dao;

import com.ldu.pojo.Comments;
import com.ldu.pojo.CommentExtend;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.ldu.pojo.Goods;

public interface GoodsMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int deleteByPrimaryKeys(Integer p0);
    
    int insert(Goods p0);
    
    int insertSelective(Goods p0);
    
    Goods selectByPrimaryKey(Integer p0);
    
    Goods selectById(Integer p0);
    
    int updateByPrimaryKeySelective(Goods p0);
    
    int updateByPrimaryKeyWithBLOBs(Goods p0);
    
    int updateByPrimaryKey(Goods p0);
    
    List<Goods> selectAllGoods();
    
    List<Goods> searchGoods(@Param("name") String p0, @Param("describle") String p1);
    
    List<Goods> selectByStr(@Param("limit") Integer p0, @Param("name") String p1, @Param("describle") String p2);
    
    List<Goods> selectByCatelog(@Param("catelog_id") Integer p0, @Param("name") String p1, @Param("describle") String p2);
    
    List<Goods> selectByDate(int p0, int p1);
    
    List<Goods> selectByCatelogOrderByDate(@Param("catelogId") Integer p0, @Param("limit") Integer p1);
    
    List<Goods> selectOrderByDate(@Param("limit") Integer p0);
    
    List<Goods> getGoodsByUserId(Integer p0);
    
    int updateGoodsByGoodsId(Goods p0);
    
    List<Goods> getGoodsList();
    
    List<Goods> getPageGoodsByGoods(@Param("id") Integer p0, @Param("name") String p1, @Param("form") Integer p2);
    
    CommentExtend selectCommentsByGoodsId(@Param("id") Integer p0);
    
    void addComments(Comments p0);
}
