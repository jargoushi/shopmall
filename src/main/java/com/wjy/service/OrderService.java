package com.wjy.service;

import com.wjy.domain.Order;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:09
 * @Description:
 */
public interface OrderService {
    List<Order> queryOrdersBySend();

    List<Order> queryOrdersByReceiver();

    List<Order> queryOrdersByComplete();

    List<Order> queryOrderBuUserId(Integer userId);

    boolean deleteOrder(Integer orderId);

    boolean updateOrder(Integer orderId);
}
