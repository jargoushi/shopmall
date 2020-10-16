package com.wjy.controller.front;

import com.wjy.service.GoodsService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 15:43
 * @Description:
 */
@Controller
public class MainController {


    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/main")
    public ModelAndView showMainVoew(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("digGoods", goodsService.queryGoodsByCategory("数码"));
        modelAndView.addObject("houseGoods",goodsService.queryGoodsByCategory("家电") );
        modelAndView.addObject("colGoods", goodsService.queryGoodsByCategory("服饰"));
        modelAndView.addObject("bookGoods", goodsService.queryGoodsByCategory("书籍"));

        modelAndView.setViewName("main");

        return modelAndView;
    }


}
