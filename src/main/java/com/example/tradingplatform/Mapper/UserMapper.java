package com.example.tradingplatform.Mapper;

import com.example.tradingplatform.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper{
    User selectUserById(String userId);

    void updateUserById(@Param("userId") String userId, @Param("user") User user);
}
