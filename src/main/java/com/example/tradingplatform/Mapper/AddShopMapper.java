package com.example.tradingplatform.Mapper;

import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface AddShopMapper{
    int addProductByUserId(@Param("userId") String userId, @Param("shop") Shop shop);

    Shop selectProductByUserIdAndName(@Param("userId") String userId, @Param("productName") String productName);

    void updateProductByUserIdAndName(@Param("userId") String userId, @Param("productName") String productName, @Param("productCount") Integer productCount);
}
