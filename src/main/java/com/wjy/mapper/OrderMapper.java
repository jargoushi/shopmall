package com.wjy.mapper;

import com.wjy.domain.Order;

import java.util.List;
import java.util.Map; /**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:14
 * @Description:
 */
public interface OrderMapper {
    List<Order> queryOrders(Map<String, Integer> map);

    List<Order> queryOrderBuUserId(Integer userId);

    int deleteOrder(Integer orderId);

    int updateOrder(Integer orderId);
}
