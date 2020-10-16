package com.wjy.mapper;

import com.wjy.domain.ShopCart;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 21:23
 * @Description:
 */
public interface ShopCartMapper {
    List<ShopCart> queryShopCartByUserId(Integer userId);
}
