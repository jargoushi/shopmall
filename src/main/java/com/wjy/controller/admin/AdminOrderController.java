package com.wjy.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjy.domain.Address;
import com.wjy.domain.Goods;
import com.wjy.domain.Order;
import com.wjy.domain.OrderItem;
import com.wjy.service.AddressService;
import com.wjy.service.GoodsService;
import com.wjy.service.OrderItemService;
import com.wjy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:06
 * @Description:
 */
@Controller
@RequestMapping("/admin/order/")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/send")
    public ModelAndView showSendOrder(@RequestParam(defaultValue = "1") Integer page) {


        PageHelper.startPage(page, 5);

        List<Order> orders = orderService.queryOrdersBySend();

        ModelAndView modelAndView = getModelAndView(orders);

        return modelAndView;
    }

    private ModelAndView getModelAndView(List<Order> orders) {
        if (orders != null && orders.size() > 0) {
            for (Order order : orders) {
                // 查询address
                Address address = addressService.queryAddressById(order.getAddressId());
                order.setAddress(address);
                // 查询orderItem
                List<OrderItem> orderItems = orderItemService.queryItemByOrderId(order.getOrderId());

                if (orderItems != null && orderItems.size() > 0) {

                    // 查询goods
                    for (OrderItem orderItem : orderItems) {
                        List<Goods> goods = goodsService.queryGoodsById(orderItem.getGoodsId());
                        order.setGoodsInfo(goods);
                    }

                }

            }
        }

        PageInfo pageInfo = new PageInfo(orders);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("adminAllOrder");
        return modelAndView;
    }


    @RequestMapping("/receiver")
    public ModelAndView showReceiverOrder(@RequestParam(defaultValue = "1") Integer page) {


        PageHelper.startPage(page, 5);

        List<Order> orders = orderService.queryOrdersByReceiver();

        ModelAndView modelAndView = getModelAndView(orders);

        return modelAndView;
    }

    @RequestMapping("/complete")
    public ModelAndView showCompleteOrder(@RequestParam(defaultValue = "1") Integer page) {


        PageHelper.startPage(page, 5);

        List<Order> orders = orderService.queryOrdersByComplete();

        ModelAndView modelAndView = getModelAndView(orders);

        return modelAndView;
    }
}
