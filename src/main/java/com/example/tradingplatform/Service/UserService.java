package com.example.tradingplatform.Service;

import com.example.tradingplatform.pojo.User;
import com.example.tradingplatform.response.Resp;

public interface UserService {
    User selectUserById(String userId);

    Resp<Void> updateUserById(String userId, User user);
}
