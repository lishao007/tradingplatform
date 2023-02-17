package com.example.tradingplatform.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tradingplatform.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {

    int addOrderByUserId(@Param("userId") String userId, @Param("order") Order order);

    Order selectOrderByUserIdAndProductName(@Param("userId") String userId, @Param("productName") String productName);

    void updateOrderByUserIdAndProductName(@Param("userId") String userId, @Param("productName") String productName, @Param("number") Integer number);
}
