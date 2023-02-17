package com.example.tradingplatform.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface AddShopMapper extends BaseMapper<Shop> {
    int addProductByUserId(@Param("userId") String userId, @Param("shop") Shop shop);

    Shop selectProductByUserIdAndName(@Param("userId") String userId, @Param("productName") String productName);

    void updateProductByUserIdAndName(@Param("userId") String userId, @Param("productName") String productName, @Param("productCount") Integer productCount);

}
