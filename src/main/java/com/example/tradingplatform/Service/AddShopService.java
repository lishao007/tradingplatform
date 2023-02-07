package com.example.tradingplatform.Service;

import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;

public interface AddShopService {
    Resp<Void> addProductByUserId(String id, Shop shop);

    Shop selectProductByUserIdAndName(String userId, String productName);

    Resp<Void> updateProductByUserIdAndName(String userId, String productName, Integer productCount);
}
