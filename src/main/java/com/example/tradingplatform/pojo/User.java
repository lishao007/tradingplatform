package com.example.tradingplatform.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class User implements Serializable {
    @ApiModelProperty(value = "用户id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "用户账号")
    private String userNumber;
    @ApiModelProperty(value = "用户密码")
    private String userPassword;
    @ApiModelProperty(value = "用户头像")
    private String userPhoto;
    @ApiModelProperty(value = "用户性别")
    private String userSex;
    @ApiModelProperty(value = "用户年龄")
    private int userAge;
    @TableField(exist = false)
    private List<Order> orderList;
    @TableField(exist = false)
    private List<Shop> shopList;
}
