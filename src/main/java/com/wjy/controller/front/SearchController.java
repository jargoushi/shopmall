package com.wjy.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjy.domain.Goods;
import com.wjy.domain.ImagePath;
import com.wjy.service.GoodsService;
import com.wjy.service.ImagePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 23:14
 * @Description:
 */
@Controller
public class SearchController {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ImagePathService imagePathService;


    @RequestMapping("/search")
    public ModelAndView showSearch(@RequestParam(defaultValue = "1")Integer page,String keyword) {

        PageHelper.startPage(page, 5);

        ModelAndView modelAndView = new ModelAndView();

        List<Goods> goods = goodsService.queryGoodsByName(keyword);

        if (goods != null && goods.size() > 0) {

            for (Goods good : goods) {

                List<ImagePath> imagePaths = imagePathService.queryImagePath(good.getGoodsId());

                good.setImagePaths(imagePaths);

                String goodsName = good.getGoodsName();

                if(goodsName.length() > 10){

                    good.setGoodsName(goodsName.substring(0,10));
                }
            }
        }

        PageInfo pageInfo = new PageInfo(goods);

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.setViewName("search");

        return modelAndView;
    }
}
