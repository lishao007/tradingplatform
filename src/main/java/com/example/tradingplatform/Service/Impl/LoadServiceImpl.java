package com.example.tradingplatform.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.Mapper.LoadMapper;
import com.example.tradingplatform.Service.LoadService;
import com.example.tradingplatform.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadServiceImpl implements LoadService {
    @Autowired
    private LoadMapper loadMapper;

    @Override
    public User getOne(QueryWrapper<User> querywrapper) {
        return loadMapper.selectOne(querywrapper);
    }
}
