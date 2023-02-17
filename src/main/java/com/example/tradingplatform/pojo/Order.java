package com.example.tradingplatform.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "`order`")
public class Order implements Serializable {
    @ApiModelProperty(value = "商品id")
    @TableId(type = IdType.AUTO)
    private Integer productId;
    @ApiModelProperty(value = "商品名称")
    private String productName;
    @ApiModelProperty(value = "商品价格")
    private BigDecimal productPrice;
    @ApiModelProperty(value = "商品图片")
    private String productPhoto;
    @ApiModelProperty(value = "下单时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime createTime;
    @ApiModelProperty(value = "订单数量")
    private int productCount;
    @ApiModelProperty(value = "订单状态,待支付为false,已支付为true")
    private boolean productStatus;
    @ApiModelProperty(value = "卖家id")
    private String id;
    @TableField(exist = false)
    private User user;
}
