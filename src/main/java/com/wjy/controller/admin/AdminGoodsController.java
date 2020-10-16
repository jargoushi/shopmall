package com.wjy.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjy.domain.Goods;
import com.wjy.domain.ImagePath;
import com.wjy.domain.ResponseResult;
import com.wjy.service.CategoryService;
import com.wjy.service.FileService;
import com.wjy.service.GoodsService;
import com.wjy.service.ImagePathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 17:55
 * @Description:
 */
@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    private static final Logger logger = LoggerFactory.getLogger(AdminGoodsController.class);


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FileService fileService;

    @Autowired
    private ImagePathService imagePathService;


    @RequestMapping("/showjson")
    @ResponseBody
    public ResponseResult showGoods(@RequestParam(value = "page", defaultValue = "1") Integer page) {

        PageHelper.startPage(page, 5);

        List<Goods> goods = goodsService.queryGoods();

        PageInfo pageInfo = new PageInfo(goods);

        Map<String, Object> info = new HashMap<String, Object>();

        info.put("pageInfo", pageInfo);

        return ResponseResult.success(info);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult updateGoods(Goods goods) {


        logger.info("修改商品信息 start, 请求参数:{}", goods);

        boolean flag = goodsService.updateGoods(goods);

        logger.info("修改商品信息: {}", flag);
        if (flag) {
            return ResponseResult.success("修改商品信息成功", null);
        }
        return ResponseResult.fail("修改商品信息失败");
    }

    @RequestMapping("/delete/{goodsId}")
    @ResponseBody
    public ResponseResult deleteGoods(@PathVariable Integer goodsId) {


        boolean flag = goodsService.deleteGoods(goodsId);
        if (flag) {
            return ResponseResult.success("删除商品信息成功", null);
        }
        return ResponseResult.fail("删除商品信息失败");
    }


    @RequestMapping("/toAddGoodsView")
    public ModelAndView showAddGoodsView() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("addGoods");

        modelAndView.addObject("categoryList", categoryService.queryCategory());

        return modelAndView;
    }

    @RequestMapping("/addGoodInfo")
    public String showAddGoodInfo(Goods goods) {

        // 1. 添加商品信息
        goodsService.insertGoods(goods);

        // 2. 上传图片
        String path = fileService.upload(goods.getFileToUpload());

        // 3. 插入imagePath表
        ImagePath imagePath = new ImagePath();
        imagePath.setGoodId(goods.getGoodsId());
        imagePath.setPath(path);
        imagePathService.insert(imagePath);

        return "redirect:/admin/goods/show";
    }

    @RequestMapping("/toAddCategoryView")
    public ModelAndView showAddCategoryView() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("addCategory");

        return modelAndView;
    }


    @RequestMapping(value = "/addCategoryResult", method = RequestMethod.POST)
    public String addCategoryResult(String cateName){

        categoryService.insert(cateName);

        return "addCategory";
    }



}
