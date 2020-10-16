package com.wjy.service.Impl;

import com.wjy.domain.ShopCart;
import com.wjy.mapper.ShopCartMapper;
import com.wjy.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 21:23
 * @Description:
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {


    @Autowired
    private ShopCartMapper shopCartMapper;


    public List<ShopCart> queryShopCartByUserId(Integer userId) {
        return shopCartMapper.queryShopCartByUserId(userId);
    }
}
