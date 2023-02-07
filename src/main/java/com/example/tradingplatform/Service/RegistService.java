package com.example.tradingplatform.Service;

import com.example.tradingplatform.pojo.User;

public interface RegistService {
    User selectOne(String userNumber);

    void insert(User user);
}
