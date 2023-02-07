package com.example.tradingplatform.Service;

import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;

public interface OrderService {
    Resp<Void> deleteOrderByUserId(Integer productId);

    int addOrderByUserId(String userId, Order order);

    Order selectOrderByUserId(String userId);

    void updateOrderByUserId(String userId, Integer number);
}
