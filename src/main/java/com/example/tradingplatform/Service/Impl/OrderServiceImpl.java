package com.example.tradingplatform.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tradingplatform.Mapper.OrderMapper;
import com.example.tradingplatform.Service.OrderService;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService {
    @Override
    public Resp<Void> deleteOrderByUserId(Integer productId) {
        baseMapper.deleteById(productId);
        return Resp.ok("success");
    }

    @Override
    public int addOrderByUserId(String userId, Order order) {
        return baseMapper.addOrderByUserId(userId,order);
    }


    @Override
    public List<Order> selectList(QueryWrapper<Order> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Order selectOrderByUserIdAndProductName(String userId, String productName) {
        return baseMapper.selectOrderByUserIdAndProductName(userId,productName);
    }

    @Override
    public void updateOrderByUserIdAndProductName(String userId, String productName, Integer number) {
        baseMapper.updateOrderByUserIdAndProductName(userId,productName,number);
    }

}
