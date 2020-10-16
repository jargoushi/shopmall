package com.wjy.service;

import com.wjy.domain.OrderItem;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:43
 * @Description:
 */
public interface OrderItemService {
    List<OrderItem> queryItemByOrderId(Integer orderId);

    OrderItem queryOrderItemByOrderId(Integer orderId);
}
