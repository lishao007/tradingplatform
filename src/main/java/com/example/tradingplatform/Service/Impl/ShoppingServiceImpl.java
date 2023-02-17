package com.example.tradingplatform.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tradingplatform.Mapper.ShoppingMapper;
import com.example.tradingplatform.Service.ShoppingService;
import com.example.tradingplatform.pojo.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImpl extends ServiceImpl<ShoppingMapper,Shop> implements ShoppingService {
    @Override
    public List<Shop> selectList() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<Shop> selectList(QueryWrapper<Shop> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

}
