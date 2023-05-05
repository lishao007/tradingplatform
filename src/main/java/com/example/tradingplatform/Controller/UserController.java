package com.example.tradingplatform.Controller;

import com.example.tradingplatform.Service.Impl.UserServiceImpl;
import com.example.tradingplatform.exception.AppExceptionCodeMsg;
import com.example.tradingplatform.pojo.User;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //根据用户id,得到用户的所有详细信息（名字，头像......）User
    @GetMapping("/showUser/{userId}")
    @ApiOperation(httpMethod = "GET", value = "展示用户详情")
    public Resp<User> showUser(@PathVariable("userId") String userId) {
        User one = userService.selectUserById(userId);
        User user = new User();
        user.setUserName(one.getUserName());
        user.setUserPhoto(one.getUserPhoto());
        user.setUserNumber(one.getUserNumber());
        user.setUserPassword(one.getUserPassword());
        user.setUserSex(one.getUserSex());
        user.setUserAge(one.getUserAge());
        return Resp.ok(user);
    }

    //根据用户id修改用户信息（禁止修改图片）
    @PostMapping("/alterUserById/{userId}")
    @ApiOperation(httpMethod = "POST", value = "修改完善用户信息")
    public Resp<Void> alterUserById(@PathVariable("userId") String userId, @RequestBody User user) {
        User one = userService.selectUserById(userId);
        if (null != one) {
            one.setUserName(user.getUserName());
            one.setUserSex(user.getUserSex());
            one.setUserAge(user.getUserAge());
            return userService.updateUserById(userId, one);
        }
        return Resp.fail(AppExceptionCodeMsg.USER_FALSE);
    }
}
