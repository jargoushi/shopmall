package com.wjy.controller.front;

import com.wjy.domain.*;
import com.wjy.service.AddressService;
import com.wjy.service.GoodsService;
import com.wjy.service.ImagePathService;
import com.wjy.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 15:31
 * @Description:
 */
@Controller
public class OrderController {


    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ImagePathService imagePathService;

    @Autowired
    private AddressService addressService;


    @RequestMapping("/order")
    public ModelAndView showOrder(HttpSession session) {

        User user =(User)session.getAttribute("user");

        ModelAndView modelAndView = new ModelAndView();

        if (user == null) {

            modelAndView.setViewName("/login");

            return modelAndView;
        }

        List<Goods> goodsList = null;

        List<ShopCart> shopCarts = shopCartService.queryShopCartByUserId(user.getUserId());

        List<Address> addressList = addressService.queryAddressByUserId(user.getUserId());

        Integer oldTotalPrice = 0;
        Integer totalPrice = 0;

        if (shopCarts != null && shopCarts.size() > 0) {

            for (ShopCart shopCart : shopCarts) {

                goodsList = goodsService.queryGoodsById(shopCart.getGoodsId());

                if (goodsList != null && goodsList.size() > 0) {

                    for (Goods goods : goodsList) {
                        Integer price = goods.getPrice() * goods.getNum();

                        oldTotalPrice += price;

//                        totalPrice += price *

                        goods.setNewPrice(price);

                        List<ImagePath> imagePaths = imagePathService.queryImagePath(goods.getGoodsId());

                        goods.setImagePaths(imagePaths);
                    }
                }
            }
        }


        modelAndView.addObject("oldTotalPrice", oldTotalPrice);

        modelAndView.addObject("totalPrice", totalPrice);

        modelAndView.addObject("goodsAndImage", goodsList);

        modelAndView.addObject("address", addressList);

        modelAndView.setViewName("orderConfirm");

        return modelAndView;
    }
}
