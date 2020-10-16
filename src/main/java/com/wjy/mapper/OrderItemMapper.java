package com.wjy.mapper;

import com.wjy.domain.OrderItem;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:44
 * @Description:
 */
public interface OrderItemMapper {
    List<OrderItem> queryItemByOrderId(Integer orderId);

    OrderItem queryOrderItemByOrderId(Integer orderId);
}
