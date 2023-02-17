package com.example.tradingplatform.Controller;

import com.example.tradingplatform.Service.Impl.RegistServiceImpl;
import com.example.tradingplatform.exception.AppExceptionCodeMsg;
import com.example.tradingplatform.pojo.User;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@Api(tags = "用户注册")
public class RegistController {
    @Autowired
    private RegistServiceImpl registService;

    @PostMapping("/regist")
    @ApiOperation(httpMethod = "POST", value = "新用户注册")
    public Resp<String> regist(@RequestParam("userNumber") String userNumber, @RequestParam("userPassword") String userPassword){
        User one = registService.selectOne(userNumber);
        if(StringUtils.isBlank(userPassword)){
            //密码为空
            return Resp.fail(AppExceptionCodeMsg.PASSWORD_IS_NULL);
        } else if (null != one) {
            //用户已存在
            return Resp.fail(AppExceptionCodeMsg.USER_IS_EXISTS);
        }else {
            //注册新用户
            User user = new User();
            UUID uuid = UUID.randomUUID();
            String strUUID = uuid.toString().replaceAll("-", "");
            user.setId(strUUID);
            user.setUserNumber(userNumber);
            user.setUserPassword(userPassword);
            registService.insert(user);
            return Resp.ok(strUUID);
        }
    }
}
