package com.example.tradingplatform.Controller;

import com.example.tradingplatform.Service.Impl.AddShopDetialServiceImpl;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/addShopDetial")
@Api(tags = "添加商品详情管理")
public class AddShopDetialController {

    @Autowired
    private AddShopDetialServiceImpl addShopDetialService;

    //卖家根据商品Id,修改商品信息(禁止修改图片)
    @PostMapping("/alterProductById")
    @ApiOperation(httpMethod = "POST", value = "添加商品页修改商品信息")
    public Resp<Void> alterProductById(@RequestParam("productId") Integer productId, @RequestBody Shop shop) {
        Shop one = new Shop();
        one.setProductName(shop.getProductName());
        one.setProductPrice(shop.getProductPrice());
        one.setProductDetial(shop.getProductDetial());
        one.setProductCount(shop.getProductCount());
        addShopDetialService.alterProductById(productId, one);
        return Resp.ok("success");
    }
}
