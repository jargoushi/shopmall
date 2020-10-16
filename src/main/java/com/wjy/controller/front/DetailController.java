package com.wjy.controller.front;

import com.wjy.domain.*;
import com.wjy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/9 16:26
 * @Description:
 */
@Controller
public class DetailController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ImagePathService imagePathService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/detail")
    public ModelAndView showDetail(Integer goodsId) {

        Goods goods = goodsService.queryGoodsByGoodsId(goodsId);

        Activity activity = activityService.queryActivityById(goods.getActivityId());

        goods.setActivity(activity);

        List<ImagePath> imagePath = imagePathService.queryImagePath(goods.getGoodsId());

        List<Comment> comment = commentService.queryCommentByGoodsId(goods.getGoodsId());

        Category category =  categoryService.queryCategoryById(goods.getCategory());

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("goods",goods );

        map.put("image", imagePath);

        map.put("cate", category);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("goodsInfo", map);

        modelAndView.addObject("commentList", comment);

        modelAndView.setViewName("detail");

        return modelAndView;
    }
}
