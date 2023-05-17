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

    //卖家根据商品Id,修改商品信息
    @PostMapping("/alterProductById")
    @ApiOperation(httpMethod = "POST", value = "添加商品页修改商品信息")
    public Resp<Void> alterProductById(@RequestParam("productId") Integer productId, @RequestParam("productName") String productName, @RequestParam("photo") MultipartFile photo, @RequestParam("productPrice")BigDecimal productPrice, @RequestParam("productDetial") String productDetial, @RequestParam("productCount") Integer productCount){
        String productPhoto = null;
        Shop shop = new Shop();
        shop.setProductName(productName);
        shop.setProductPrice(productPrice);
        shop.setProductDetial(productDetial);
        shop.setProductCount(productCount);
        if(!photo.isEmpty()){
            String originalFileName = photo.getOriginalFilename();
            String suffixName = originalFileName.substring(originalFileName.lastIndexOf('.'));
            productPhoto = UUID.randomUUID().toString()+suffixName;
            try{
                photo.transferTo(new File("C:\\Users\\ZC\\Pictures\\联想安卓照片//"+productPhoto));
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        shop.setProductPhoto(productPhoto);
        addShopDetialService.alterProductById(productId,shop);
        return Resp.ok("success");
    }
}
