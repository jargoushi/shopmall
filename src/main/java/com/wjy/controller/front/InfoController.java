package com.wjy.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjy.domain.*;
import com.wjy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 15:23
 * @Description:
 */
@Controller
public class InfoController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ImagePathService imagePathService;

    @Autowired
    private CommentService commentService;


    @RequestMapping("/info/list")
    public ModelAndView showList(HttpSession session) {

        User user =(User)session.getAttribute("user");

        ModelAndView modelAndView = new ModelAndView();

        if (user == null) {

            modelAndView.setViewName("/login");

            return modelAndView;
        }

        List<Order> orderList =  orderService.queryOrderBuUserId(user.getUserId());

        if (orderList != null && orderList.size() > 0) {

            for (Order order : orderList) {

                Address address = addressService.queryAddressById(order.getAddressId());

                order.setAddress(address);

                OrderItem orderItem = orderItemService.queryOrderItemByOrderId(order.getOrderId());

                List<Goods> goods = goodsService.queryGoodsById(orderItem.getGoodsId());

                order.setGoodsInfo(goods);
            }
        }

        modelAndView.addObject("orderList", orderList);

        modelAndView.setViewName("list");

        return modelAndView;
    }

    @RequestMapping("/deleteList")
    @ResponseBody
    public ResponseResult showDeleteList(Order order) {

        boolean flag = orderService.deleteOrder(order.getOrderId());

        if (flag) {

            return ResponseResult.success("删除成功", null);
        }

        return ResponseResult.fail("删除失败");
    }

    @RequestMapping("/finishList")
    @ResponseBody
    public ResponseResult showFinishList(Order order) {

        boolean flag = orderService.updateOrder(order.getOrderId());

        if (flag) {

            return ResponseResult.success("点击成功", null);
        }

        return ResponseResult.fail("点击失败");
    }

    @RequestMapping("/comment")
    @ResponseBody
    public ResponseResult showComment(Comment comment,HttpSession session) {

        User user =(User)session.getAttribute("user");

        if (user == null) {

            return ResponseResult.fail("评论失败");
        }
        comment.setUserId(user.getUserId());

        comment.setCommentTime(new Date());

        boolean flag = commentService.insertComment(comment);

        if (flag) {

            return ResponseResult.success("评论成功", null);
        }

        return ResponseResult.fail("评论失败");
    }

    @RequestMapping("/info/address")
    public ModelAndView showAddress(HttpSession session) {

        User user =(User)session.getAttribute("user");

        ModelAndView modelAndView = new ModelAndView();

        if (user == null) {

            modelAndView.setViewName("/login");

            return modelAndView;
        }

        List<Address> addressList = addressService.queryAddressByUserId(user.getUserId());

        modelAndView.addObject("addressList", addressList);

        modelAndView.setViewName("address");

        return modelAndView;
    }

    @RequestMapping("/saveAddr")
    @ResponseBody
    public ResponseResult showSaveAddr(Address saveAddr) {

        boolean flag = addressService.updateAddress(saveAddr);

        if (flag) {

            return ResponseResult.success("修改成功", null);
        }

        return ResponseResult.fail("更新失败");
    }

    @RequestMapping("/deleteAddr")
    @ResponseBody
    public ResponseResult showDeleteAddr(Address address) {

        boolean flag = addressService.deleteAddress(address);

        if (flag) {

            return ResponseResult.success("删除成功", null);
        }

        return ResponseResult.fail("删除失败");
    }

    @RequestMapping("/insertAddr")
    @ResponseBody
    public ResponseResult showInsertAddr(Address insertAddr,HttpSession session) {

        User user =(User)session.getAttribute("user");

        if (user == null) {

            return ResponseResult.fail("添加失败");
        }
        insertAddr.setUserId(user.getUserId());

        boolean flag = addressService.insertAddress(insertAddr);

        if (flag) {

            return ResponseResult.success("添加成功", null);
        }

        return ResponseResult.fail("添加失败");
    }


    @RequestMapping("/info/favorite")
    public ModelAndView showFavorite(@RequestParam(defaultValue = "1")Integer page) {

        PageHelper.startPage(page, 5);

        List<Goods> goods = goodsService.queryGoods();

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

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.setViewName("favorite");

        return modelAndView;
    }
}
