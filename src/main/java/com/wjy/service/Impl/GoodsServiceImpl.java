package com.wjy.service.Impl;

import com.wjy.domain.Category;
import com.wjy.domain.Goods;
import com.wjy.domain.ImagePath;
import com.wjy.mapper.CategoryMapper;
import com.wjy.mapper.GoodsMapper;
import com.wjy.mapper.ImagePathMapper;
import com.wjy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 17:56
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ImagePathMapper imagePathMapper;

    public List<Goods> queryGoods() {

        return goodsMapper.queryGoods();
    }

    public boolean updateGoods(Goods goods) {
        goods.setUpTime(new Date());
        return goodsMapper.updateGoods(goods) > 0;
    }

    public boolean insertGoods(Goods goods) {
        goods.setUpTime(new Date());
        return goodsMapper.insertGoods(goods) > 0;
    }

    public boolean deleteGoods(Integer goodsId) {
        return goodsMapper.deleteGoods(goodsId) > 0;
    }

    public boolean updateActivityId(Integer activityId,Integer goodsId) {
        return goodsMapper.updateActivityId(activityId,goodsId) > 0;
    }

    public List<Goods> queryGoodsById(Integer goodsId) {
        return goodsMapper.queryGoodsById(goodsId);
    }

    public List<Goods> queryGoodsByCategory(String category) {

        List<Category> categories = categoryMapper.queryCategoryByName(category);

        if (categories != null && categories.size() > 0) {

            for (Category category1 : categories) {

                List<Goods> goods = goodsMapper.queryGoodsByCategory(category1.getCateId());

                if (goods != null && goods.size() > 0) {

                    for (Goods good : goods) {

                        String goodsName = good.getGoodsName();

                        if(goodsName.length() > 10){

                            good.setGoodsName(goodsName.substring(0,10));
                        }


                        List<ImagePath> imagePath = imagePathMapper.queryImagePath(good.getGoodsId());

                        good.setImagePaths(imagePath);

                        good.setFav(true);
                    }
                }
                return goods;
            }
        }

        return Collections.emptyList();
    }

    public Goods queryGoodsByGoodsId(Integer goodsId) {
        return goodsMapper.queryGoodsByGoodsId(goodsId);
    }

    public List<Goods> queryGoodsByName(String keyword) {
        return goodsMapper.queryGoodsByName(keyword);
    }
}
