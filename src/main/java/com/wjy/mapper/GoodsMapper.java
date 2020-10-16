package com.wjy.mapper;

import com.wjy.domain.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 17:57
 * @Description:
 */
public interface GoodsMapper {

    List<Goods> queryGoods();

    int updateGoods(Goods goods);

    int insertGoods(Goods goods);

    int deleteGoods(Integer goodsId);

    int updateActivityId(@Param("activityId") Integer activityId, @Param("goodsId") Integer goodsId);

    List<Goods> queryGoodsById(Integer goodsId);

    List<Goods> queryGoodsByCategory(Integer cateId);

    Goods queryGoodsByGoodsId(Integer goodsId);

    List<Goods> queryGoodsByName(String keyword);
}
