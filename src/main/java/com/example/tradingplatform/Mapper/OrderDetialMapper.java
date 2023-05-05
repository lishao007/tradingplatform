package com.example.tradingplatform.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tradingplatform.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDetialMapper extends BaseMapper<Order> {
    void updateOrderByProductId(Integer productId);
}
