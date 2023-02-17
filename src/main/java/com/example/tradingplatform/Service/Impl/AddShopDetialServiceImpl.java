package com.example.tradingplatform.Service.Impl;

import com.example.tradingplatform.Mapper.AddShopDetialMapper;
import com.example.tradingplatform.Service.AddShopDetialService;
import com.example.tradingplatform.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddShopDetialServiceImpl implements AddShopDetialService {
    @Autowired
    private AddShopDetialMapper addShopDetialMapper;

    @Override
    public void alterProductById(Integer productId, Shop shop) {
        addShopDetialMapper.alterProductById(productId,shop);
    }
}
