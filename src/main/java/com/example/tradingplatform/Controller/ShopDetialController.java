package com.example.tradingplatform.Controller;

import com.alibaba.fastjson.JSON;
import com.example.tradingplatform.Service.Impl.OrderServiceImpl;
import com.example.tradingplatform.Service.Impl.ShopDetialServiceImpl;
import com.example.tradingplatform.exception.AppExceptionCodeMsg;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/shopDetial")
@Api(tags = "商品详情管理")
public class ShopDetialController {
    @Autowired
    private ShopDetialServiceImpl shopDetialService;
    @Autowired
    @Lazy
    private OrderServiceImpl orderService;

    @GetMapping("/selectProductDetial/{productId}")
    @ApiOperation(httpMethod = "GET", value = "查看商品详情")
    public Resp<JSON> selectProductDetial(@PathVariable("productId") Integer productId){
        //获取商品信息
        Shop one = shopDetialService.selectByProductId(productId);
        Shop shop = new Shop();
        shop.setProductName(one.getProductName());
        shop.setProductPrice(one.getProductPrice());
        shop.setProductPhoto(one.getProductPhoto());
        shop.setProductDetial(one.getProductDetial());
        shop.setProductCount(one.getProductCount());
        shop.setProductStatus(one.isProductStatus());
        return Resp.ok(JSON.toJSON(shop));
    }

    @GetMapping("/placeOrder/{userId}/{productId}")
    @ApiOperation(httpMethod = "GET", value = "用户下单")
    public Resp<Void> placeOrder(@PathVariable("userId") String userId, @PathVariable("productId") Integer productId, @RequestParam("number") Integer number){
        //获取商品信息
        Shop one = shopDetialService.selectByProductId(productId);
        String productName = one.getProductName();
        int count = one.getProductCount();
        //判断用户是否是第一次下单
        Order One = orderService.selectOrderByUserIdAndProductName(userId,productName);
        if(null != One){
            //用户不是第一次下单
            //判断当前商品数量
            if(number <= count){
                //更新订单信息(只更改订单数量即可)
                orderService.updateOrderByUserIdAndProductName(userId,productName,number);
                if(number == count){
                    //删除商品信息
                    shopDetialService.deleteShopByProductId(productId);
                    return Resp.ok("success");
                }else{
                    //更新商品信息
                    shopDetialService.updateShopByProductIdAndUserId(productId,number,one.getUser().getId());
                    return Resp.ok("success");
                }
            }else{
                return Resp.fail(AppExceptionCodeMsg.PRODUCT_NOT_EXISTS);
            }
        }else{
            //用户第一次下单
            //判断当前商品数量
            if(number <= count){
                //商品转换为订单
                Order order = new Order();
                order.setProductName(one.getProductName());
                order.setProductPrice(one.getProductPrice());
                order.setProductPhoto(one.getProductPhoto());
                order.setProductCount(number);
                order.setCreateTime(LocalDateTime.now());
                order.setId(one.getUser().getId());
                order.setProductStatus(false);//订单待支付
                //添加商品到用户订单列表
                int i = orderService.addOrderByUserId(userId,order);
                if(i != 0){
                    if(number == count){
                        //删除已下单的商品信息
                        shopDetialService.deleteShopByProductId(productId);
                        return Resp.ok("success");
                    }else{
                        //更新已下单的商品信息
                        shopDetialService.updateShopByProductIdAndUserId(productId,number,one.getUser().getId());
                        return Resp.ok("success");
                    }
                }else{
                    return Resp.fail(AppExceptionCodeMsg.ORDER_FALSE);
                }
            }else{
                return Resp.fail(AppExceptionCodeMsg.PRODUCT_NOT_EXISTS);
            }
        }

    }
}
