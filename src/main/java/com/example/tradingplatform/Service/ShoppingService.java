package com.example.tradingplatform.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;

public interface ShoppingService {

    IPage<Shop> selectPage(Page<Shop> shoppage, LambdaQueryWrapper<Shop> shopLambdaQueryWrapper);

}
