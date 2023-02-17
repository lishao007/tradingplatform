package com.example.tradingplatform.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.pojo.Shop;

import java.util.List;

public interface ShoppingService {
    List<Shop> selectList();


    List<Shop> selectList(QueryWrapper<Shop> queryWrapper);
}
