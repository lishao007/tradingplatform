package com.example.tradingplatform.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tradingplatform.Mapper.AddShopMapper;
import com.example.tradingplatform.Service.AddShopService;
import com.example.tradingplatform.exception.AppExceptionCodeMsg;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddShopServicelmpl extends ServiceImpl<AddShopMapper,Shop> implements AddShopService {
    @Override
    public Resp<Void> addProductByUserId(String userId, Shop shop) {
        if(baseMapper.addProductByUserId(userId,shop) != 0){
            return Resp.ok("success");
        }else{
            return Resp.fail(AppExceptionCodeMsg.INSERT_FALSE);
        }
    }

    @Override
    public Shop selectProductByUserIdAndName(String userId, String productName) {
        return baseMapper.selectProductByUserIdAndName(userId,productName);
    }

    @Override
    public Resp<Void> updateProductByUserIdAndName(String userId, String productName, Integer productCount) {
        baseMapper.updateProductByUserIdAndName(userId,productName,productCount);
        return Resp.ok("success");
    }

    @Override
    public List<Shop> selectByUserId(QueryWrapper<Shop> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public void deleteByProuctId(Integer productId) {
        baseMapper.deleteById(productId);
    }

}
