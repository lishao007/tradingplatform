package com.example.tradingplatform.Service.Impl;

import com.example.tradingplatform.Mapper.ShopDetialMapper;
import com.example.tradingplatform.Service.ShopDetialService;
import com.example.tradingplatform.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopDetialServiceImpl implements ShopDetialService {

    @Autowired
    private ShopDetialMapper shopDetialMapper;

    @Override
    public void updateShopByProductId(Integer productId, Integer number) {
        shopDetialMapper.updateShopByUserId(productId,number);
    }

    @Override
    public void deleteShopByProductId(Integer productId) {
        shopDetialMapper.deleteShopByUserId(productId);
    }

    @Override
    public Shop selectByProductId(Integer productId) {
        return shopDetialMapper.selectByProductId(productId);
    }
}
