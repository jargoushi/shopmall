package com.wjy.service.Impl;

import com.wjy.domain.Order;
import com.wjy.mapper.OrderMapper;
import com.wjy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:13
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> queryOrdersBySend() {

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("send", 0);

        return orderMapper.queryOrders(map);
    }

    public List<Order> queryOrdersByReceiver() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("receive", 0);

        return orderMapper.queryOrders(map);
    }

    public List<Order> queryOrdersByComplete() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("complete", 0);

        return orderMapper.queryOrders(map);
    }

    public List<Order> queryOrderBuUserId(Integer userId) {
        return orderMapper.queryOrderBuUserId(userId);
    }

    public boolean deleteOrder(Integer orderId) {
        return orderMapper.deleteOrder(orderId) > 0;
    }

    public boolean updateOrder(Integer orderId) {
        return orderMapper.updateOrder(orderId) > 0;
    }
}
