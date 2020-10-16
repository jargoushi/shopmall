package com.wjy.controller.front;

import com.wjy.domain.*;
import com.wjy.service.GoodsService;
import com.wjy.service.ImagePathService;
import com.wjy.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 15:29
 * @Description:
 */
@Controller
public class ShopCartController {


    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ImagePathService imagePathService;


    @RequestMapping("/showcart")
    public String showCart() {

        return "shopcart";
    }

    @RequestMapping("/cartJson")
    @ResponseBody
    public ResponseResult showCartJson(HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {

            return ResponseResult.fail("swal");
        }

        List<ShopCart> goodsId = shopCartService.queryShopCartByUserId(user.getUserId());

        List<Goods> goodsList = null;

        if (goodsId != null && goodsId.size() > 0) {

            for (ShopCart shopCart : goodsId) {

                goodsList = goodsService.queryGoodsById(shopCart.getGoodsId());

                if (goodsList != null && goodsList.size() > 0) {

                    for (Goods good : goodsList) {

                        List<ImagePath> imagePaths = imagePathService.queryImagePath(good.getGoodsId());

                        good.setImagePaths(imagePaths);
                    }
                }
            }
        }

        Map<String, Object> info = new HashMap<String, Object>();

        info.put("shopcart", goodsList);

        return ResponseResult.success(info);

    }
}
