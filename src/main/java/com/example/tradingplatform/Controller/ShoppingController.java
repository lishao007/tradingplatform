package com.example.tradingplatform.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tradingplatform.Service.Impl.ShoppingServiceImpl;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
@Api(tags = "商品管理")
public class ShoppingController {
    @Autowired
    private ShoppingServiceImpl shoppingService;

    @GetMapping("/show")
    @ApiOperation(httpMethod = "GET", value = "查询出所有的商品信息分页展示")
    public Resp<IPage> show(){
        Page<Shop> shopPage = new Page<>(1,5);
        IPage<Shop> shopIPage = shoppingService.selectPage(shopPage,null);
        System.out.println("总页数:"+shopIPage.getPages());
        System.out.println("总记录数:"+shopIPage.getTotal());
        shopIPage.getRecords().forEach(System.out::println);
        return Resp.ok(shopIPage);
    }

    @GetMapping("/selectPage")
    @ApiOperation(httpMethod = "GET", value = "根据用户搜索条件查询并分页展示")
    public Resp<IPage<Shop>> selectPage(){
        String str = "";
        LambdaQueryWrapper<Shop> shopLambdaQueryWrapper = new LambdaQueryWrapper<Shop>();
        shopLambdaQueryWrapper.like(Shop::getProductName,str);
        Page<Shop> shopPage = new Page<>(1,2);
        IPage<Shop> shopIPage = shoppingService.selectPage(shopPage,shopLambdaQueryWrapper);
        return Resp.ok(shopIPage);
    }



}
