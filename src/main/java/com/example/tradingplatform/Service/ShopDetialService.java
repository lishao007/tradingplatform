package com.example.tradingplatform.Service;

import com.example.tradingplatform.pojo.Shop;

public interface ShopDetialService {

    Shop selectByProductId(Integer productId);

    void deleteShopByProductId(Integer productId);

    void updateShopByProductIdAndUserId(Integer productId, Integer number, String userId);
}
