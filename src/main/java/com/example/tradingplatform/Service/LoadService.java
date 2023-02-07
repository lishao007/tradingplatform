package com.example.tradingplatform.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.pojo.User;

public interface LoadService {
    User getOne(QueryWrapper<User> querywrapper);
}
