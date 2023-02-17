package com.example.tradingplatform.Mapper;

import com.example.tradingplatform.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopDetialMapper{

    void deleteShopByUserId(Integer productId);

    Shop selectByProductId(Integer productId);

    void updateShopByProductIdAndUserId(@Param("productId") Integer productId, @Param("number") Integer number, @Param("userId") String userId);
}
