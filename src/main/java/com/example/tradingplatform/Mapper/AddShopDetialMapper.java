package com.example.tradingplatform.Mapper;

import com.example.tradingplatform.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AddShopDetialMapper {
    void alterProductById(@Param("productId")Integer productId, @Param("shop")Shop shop);
}
