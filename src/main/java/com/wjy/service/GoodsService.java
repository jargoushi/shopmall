package com.wjy.service;

import com.wjy.domain.Goods;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 17:56
 * @Description:
 */
public interface GoodsService {


    List<Goods> queryGoods();

    boolean updateGoods(Goods goods);

    boolean insertGoods(Goods goods);

    boolean deleteGoods(Integer goodsId);

    boolean updateActivityId(Integer activityId,Integer goodsId);

    List<Goods> queryGoodsById(Integer goodsId);

    List<Goods> queryGoodsByCategory(String category);

    Goods queryGoodsByGoodsId(Integer goodsId);

    List<Goods> queryGoodsByName(String keyword);
}
