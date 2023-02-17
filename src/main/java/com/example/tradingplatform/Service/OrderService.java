package com.example.tradingplatform.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;

import java.util.List;

public interface OrderService {
    Resp<Void> deleteOrderByUserId(Integer productId);

    int addOrderByUserId(String userId, Order order);

    List<Order> selectList(QueryWrapper<Order> queryWrapper);

    Order selectOrderByUserIdAndProductName(String userId, String productName);

    void updateOrderByUserIdAndProductName(String userId, String productName, Integer number);
}
