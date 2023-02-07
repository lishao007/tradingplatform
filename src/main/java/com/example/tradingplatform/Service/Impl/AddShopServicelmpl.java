package com.example.tradingplatform.Service.Impl;

import com.example.tradingplatform.Mapper.AddShopMapper;
import com.example.tradingplatform.Service.AddShopService;
import com.example.tradingplatform.exception.AppExceptionCodeMsg;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddShopServicelmpl implements AddShopService {
    @Autowired
    private AddShopMapper addShopMapper;
    @Override
    public Resp<Void> addProductByUserId(String userId, Shop shop) {
        if(addShopMapper.addProductByUserId(userId,shop) != 0){
            return Resp.ok("success");
        }else{
            return Resp.fail(AppExceptionCodeMsg.INSERT_FALSE);
        }
    }

    @Override
    public Shop selectProductByUserIdAndName(String userId, String productName) {
        return addShopMapper.selectProductByUserIdAndName(userId,productName);
    }

    @Override
    public Resp<Void> updateProductByUserIdAndName(String userId, String productName, Integer productCount) {
        addShopMapper.updateProductByUserIdAndName(userId,productName,productCount);
        return Resp.ok("success");
    }

}
