package com.example.tradingplatform.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;

import java.util.List;

public interface AddShopService {
    Resp<Void> addProductByUserId(String id, Shop shop);

    Shop selectProductByUserIdAndName(String userId, String productName);

    Resp<Void> updateProductByUserIdAndName(String userId, String productName, Integer productCount);

    List<Shop> selectByUserId(QueryWrapper<Shop> queryWrapper);

    void deleteByProuctId(Integer productId);
}
