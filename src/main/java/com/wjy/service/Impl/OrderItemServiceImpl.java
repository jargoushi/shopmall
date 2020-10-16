package com.wjy.service.Impl;

import com.wjy.domain.OrderItem;
import com.wjy.mapper.OrderItemMapper;
import com.wjy.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:43
 * @Description:
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    public List<OrderItem> queryItemByOrderId(Integer orderId) {
        return orderItemMapper.queryItemByOrderId(orderId);
    }

    public OrderItem queryOrderItemByOrderId(Integer orderId) {
        return orderItemMapper.queryOrderItemByOrderId(orderId);
    }
}
