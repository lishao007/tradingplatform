package com.example.tradingplatform.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;

import java.util.List;

public interface MyOrderService {
    List<Order> selectMyOrderById(QueryWrapper<Order> queryWrapper);
}
