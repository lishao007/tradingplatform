package com.example.tradingplatform.Service.Impl;

import com.example.tradingplatform.Mapper.UserMapper;
import com.example.tradingplatform.Service.UserService;
import com.example.tradingplatform.pojo.User;
import com.example.tradingplatform.response.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(String userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public Resp<Void> updateUserById(String userId, User user) {
        userMapper.updateUserById(userId,user);
        return Resp.ok("success");
    }
}
