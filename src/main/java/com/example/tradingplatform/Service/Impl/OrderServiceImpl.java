package com.example.tradingplatform.Service.Impl;

import com.example.tradingplatform.Mapper.OrderMapper;
import com.example.tradingplatform.Service.OrderService;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Resp<Void> deleteOrderByUserId(Integer productId) {
        orderMapper.deleteOrderByUserId(productId);
        return Resp.ok("success");
    }

    @Override
    public int addOrderByUserId(String userId, Order order) {
        return orderMapper.addOrderByUserId(userId,order);
    }

    @Override
    public Order selectOrderByUserId(String userId) {
        return orderMapper.selectOrderByUserId(userId);
    }

    @Override
    public void updateOrderByUserId(String userId, Integer number) {
        orderMapper.updateOrderByUserId(userId,number);
    }

}
