package com.wjy.service;

import com.wjy.domain.ShopCart;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 21:22
 * @Description:
 */
public interface ShopCartService {
    List<ShopCart> queryShopCartByUserId(Integer userId);
}
