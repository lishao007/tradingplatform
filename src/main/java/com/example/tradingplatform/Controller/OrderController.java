package com.example.tradingplatform.Controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.Service.Impl.OrderServiceImpl;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Api(tags = "订单管理")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/selectOrderByUserId/{userId}")
    @ApiOperation(httpMethod = "GET", value = "根据用户id查询用户订单信息")
    public Resp<JSON> selectOrderByUserId(@PathVariable("userId") String userId){
        //根据用户id获取用户订单列表
        List<Order> listOrder = orderService.selectList(new QueryWrapper<Order>()
                .eq("user_id",userId));
        return Resp.ok(listOrder);
    }

    @GetMapping("/cancel")
    @ApiOperation(httpMethod = "GET", value = "用户取消订单")
    public Resp<Void> cancel(@RequestParam("productId") Integer productId){
        //根据商品信息删除数据库中数据
        orderService.deleteOrderByUserId(productId);
        return Resp.ok("success");
    }

}
