package com.example.tradingplatform.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.Service.Impl.LoadServiceImpl;
import com.example.tradingplatform.exception.AppExceptionCodeMsg;
import com.example.tradingplatform.pojo.User;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户登陆")
public class LoadController {

    @Autowired
    private LoadServiceImpl loadService;

    @PostMapping("/login")
    @ApiOperation(httpMethod = "POST", value = "验证用户账号密码信息")
    public Resp<String> load(@RequestParam("userNumber") String userNumber, @RequestParam("userPassword") String userPassword){
        User one = loadService.getOne(new QueryWrapper<User>()
                .eq("user_number",userNumber)
                .eq("user_password",userPassword)
        );
        if(null != one){
            return Resp.ok(one.getId());
        }else{
            return Resp.fail(AppExceptionCodeMsg.USER_NOT_EXISTS);
        }
    }
    
}
