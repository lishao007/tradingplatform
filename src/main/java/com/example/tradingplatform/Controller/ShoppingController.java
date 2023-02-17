package com.example.tradingplatform.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tradingplatform.Service.Impl.ShoppingServiceImpl;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.response.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@Api(tags = "商品管理")
public class ShoppingController {
    @Autowired
    private ShoppingServiceImpl shoppingService;

    @GetMapping("/show")
    @ApiOperation(httpMethod = "GET", value = "查询出所有的商品信息展示")
    public Resp<List<Shop>> show(){
        List<Shop> shopList = shoppingService.selectList();
        return Resp.ok(shopList);
    }

    @PostMapping("/fuzzySearch")
    @ApiOperation(httpMethod = "POST", value = "根据用户搜索条件查询符合条件的商品")
    public Resp<List<Shop>> fuzzySearch(@RequestBody String str){
        System.out.println(str);
        List<Shop> shopList = shoppingService.selectList(new QueryWrapper<Shop>().
                like("product_name",str));
        return Resp.ok(shopList);
    }

}
