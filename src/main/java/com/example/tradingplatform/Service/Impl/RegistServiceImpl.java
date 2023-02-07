package com.example.tradingplatform.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.Mapper.RegistMapper;
import com.example.tradingplatform.Service.RegistService;
import com.example.tradingplatform.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistServiceImpl implements RegistService {
    @Autowired
    private RegistMapper registMapper;

    @Override
    public User selectOne(String userNumber) {
        return registMapper.selectOne(new QueryWrapper<User>().eq("user_number",userNumber));
    }

    @Override
    public void insert(User user) {
        registMapper.insert(user);
    }
}
