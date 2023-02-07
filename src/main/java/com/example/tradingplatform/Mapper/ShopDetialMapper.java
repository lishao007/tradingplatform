package com.example.tradingplatform.Mapper;

import com.example.tradingplatform.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopDetialMapper{
    void updateShopByUserId(@Param("productId") Integer productId, @Param("number") int number);

    void deleteShopByUserId(Integer productId);

    Shop selectByProductId(Integer productId);
}
