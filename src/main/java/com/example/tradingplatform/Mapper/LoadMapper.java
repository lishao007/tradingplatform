package com.example.tradingplatform.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tradingplatform.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoadMapper extends BaseMapper<User> {
}
