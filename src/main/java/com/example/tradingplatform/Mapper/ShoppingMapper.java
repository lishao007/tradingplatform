package com.example.tradingplatform.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tradingplatform.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShoppingMapper extends BaseMapper<Shop> {
}
