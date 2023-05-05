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
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "shop")
public class Shop implements Serializable {
    @ApiModelProperty(value = "商品id")
    @TableId(type = IdType.AUTO)
    private Integer productId;
    @ApiModelProperty(value = "商品名称")
    private String productName;
    @ApiModelProperty(value = "商品价格")
    private BigDecimal productPrice;
    @ApiModelProperty(value = "商品图片")
    private String productPhoto;
    @ApiModelProperty(value = "商品详情描述")
    private String productDetial;
    @ApiModelProperty(value = "商品数量")
    private int productCount;
    @ApiModelProperty(value = "商品状态,售出过为true,未售出为false")
    private boolean productStatus;
    @TableField(exist = false)
    private User user;

}
