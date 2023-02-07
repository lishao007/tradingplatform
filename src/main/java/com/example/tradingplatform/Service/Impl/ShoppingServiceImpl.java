package com.example.tradingplatform.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tradingplatform.Mapper.ShoppingMapper;
import com.example.tradingplatform.Service.ShoppingService;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public IPage<Shop> selectPage(Page<Shop> shopPage, LambdaQueryWrapper<Shop> shopLambdaQueryWrapper) {
        return shoppingMapper.selectPage(shopPage,shopLambdaQueryWrapper);
    }
}
