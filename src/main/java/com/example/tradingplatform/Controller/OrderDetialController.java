package com.example.tradingplatform.Controller;

import com.example.tradingplatform.Service.Impl.OrderDetialServiceImpl;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderDetial")
@Api(tags = "订单详情管理")
public class OrderDetialController {

    @Autowired
    private OrderDetialServiceImpl orderDetialService;

    //订单详情及支付
    @GetMapping("/showOrder")
    @ApiOperation(httpMethod = "GET", value = "展示订单详情")
    public Resp<Order> showOrderByProductId(@RequestParam("productId") Integer productId){
        Order order = orderDetialService.showOrderByProductId(productId);
        return Resp.ok(order);
    }

    @GetMapping("/pay")
    @ApiOperation(httpMethod = "GET", value = "用户支付订单")
    public Resp<Void> pay(@RequestParam("productId") Integer productId){
        orderDetialService.updateOrderByProductId(productId);
        return Resp.ok();
    }
}
