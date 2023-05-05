package com.example.tradingplatform.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tradingplatform.Mapper.OrderDetialMapper;
import com.example.tradingplatform.Service.OrderDetialService;
import com.example.tradingplatform.pojo.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderDetialServiceImpl extends ServiceImpl<OrderDetialMapper,Order> implements OrderDetialService {
    @Override
    public Order showOrderByProductId(Integer productId) {
        return baseMapper.selectById(productId);
    }

    @Override
    public void updateOrderByProductId(Integer productId) {
        baseMapper.updateOrderByProductId(productId);
    }
}
