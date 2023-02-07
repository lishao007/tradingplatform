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

    @PostMapping("/alterUserById/{userId}")
    @ApiOperation(httpMethod = "POST",value = "修改完善用户信息")
    public Resp<Void> alterUserById(@PathVariable("userId") String userId, @RequestParam("photo") MultipartFile photo, @RequestParam("userName") String userName, @RequestParam("userSex") String userSex, @RequestParam("userAge") Integer userAge){
        String userPhoto = null;
        User user = userService.selectUserById(userId);
        if(null != user){
            user.setUserName(userName);
            user.setUserSex(userSex);
            user.setUserAge(userAge);
            if(!photo.isEmpty()){
                String originalFileName = photo.getOriginalFilename();
                String suffixName = originalFileName.substring(originalFileName.lastIndexOf('.'));
                userPhoto = UUID.randomUUID().toString()+suffixName;
                try{
                    photo.transferTo(new File("C:\\Users\\ZC\\Pictures\\联想安卓照片//"+userPhoto));
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            user.setUserPhoto(userPhoto);
            return userService.updateUserById(userId,user);
        }
        return Resp.fail(AppExceptionCodeMsg.USER_FALSE);

    }
}
