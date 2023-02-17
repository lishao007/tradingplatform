package com.example.tradingplatform.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.Service.Impl.AddShopServicelmpl;
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
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/addShop")
@Api(tags = "添加商品管理")
public class AddShopController {
    @Autowired
    private AddShopServicelmpl addShopService;

    //根据用户ID，查询该用户所有从未售出过以及没有卖完的商品的列表。List<Shop>
    @GetMapping("/selectByUserId/{userId}")
    @ApiOperation(httpMethod = "GET", value = "查看用户添加的从未售出过以及没有卖完的商品")
    public Resp<List<Shop>> selectByUserId(@PathVariable("userId") String userId){
        List<Shop> listShop = addShopService.selectByUserId(new QueryWrapper<Shop>()
                .eq("user_id",userId));
        return Resp.ok(listShop);
    }

    //卖家根据商品Id,删除未出售的商品
    @GetMapping("/deleteByProuctId")
    @ApiOperation(httpMethod = "GET", value = "删除从未售出过以及没有卖完的商品")
    public Resp<Void> deleteByProuctId(@RequestParam("productId") Integer productId){
        addShopService.deleteByProuctId(productId);
        return Resp.ok("success");
    }

    @PostMapping("/addProductByUserId/{userId}")
    @ApiOperation(httpMethod = "POST", value = "添加商品")
    public Resp<Void> addProductByUserId(@PathVariable("userId") String userId, @RequestParam("productName") String productName, @RequestParam("productPrice") BigDecimal productPrice, @RequestParam("photo") MultipartFile photo, @RequestParam("productDetial") String productDetial, @RequestParam("productCount") Integer productCount){
        //根据用户id和商品名称判断是否是第一次添加商品
        Shop shop = addShopService.selectProductByUserIdAndName(userId,productName);
        if(null != shop){
            //该用户不是第一次添加商品
            //更新该商品信息
            return addShopService.updateProductByUserIdAndName(userId,productName,productCount);
        }else{
            //该用户第一次添加商品
            //获取商品信息
            String productPhoto = null;
            Shop one = new Shop();
            one.setProductName(productName);
            one.setProductPrice(productPrice);
            one.setProductDetial(productDetial);
            one.setProductCount(productCount);
            one.setProductStatus(false);//商品状态设为未售出
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
            one.setProductPhoto(productPhoto);
            //添加商品到商品数据库
            return addShopService.addProductByUserId(userId,one);
        }
    }
}
