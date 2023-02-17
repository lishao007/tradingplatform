package com.example.tradingplatform.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tradingplatform.Mapper.MyOrderMapper;
import com.example.tradingplatform.Service.MyOrderService;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyOrderServiceImpl extends ServiceImpl<MyOrderMapper,Order> implements MyOrderService {
    @Override
    public List<Order> selectMyOrderById(QueryWrapper<Order> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }
}
