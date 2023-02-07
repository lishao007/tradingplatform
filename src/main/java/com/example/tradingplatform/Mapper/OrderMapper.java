package com.example.tradingplatform.Mapper;

import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper{
    void deleteOrderByUserId(Integer productId);

    int addOrderByUserId(@Param("userId") String userId, @Param("order") Order order);

    Order selectOrderByUserId(String userId);

    void updateOrderByUserId(@Param("userId") String userId, @Param("number") Integer number);
}
