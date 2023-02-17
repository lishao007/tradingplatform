package com.example.tradingplatform.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.Service.Impl.MyOrderServiceImpl;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myOrder")
@Api(tags = "我的卖出的订单")
public class MyOrderController {
    @Autowired
    private MyOrderServiceImpl myOrderService;

    @GetMapping("/selectMyOrderById/{userId}")
    @ApiOperation(httpMethod = "GET", value = "查看卖出的订单")
    public Resp<List<Order>> selectMyOrderById(@PathVariable("userId") String userId){
        List<Order> orderList =  myOrderService.selectMyOrderById(new QueryWrapper<Order>()
                .eq("id",userId));
        return Resp.ok(orderList);
    }
}
