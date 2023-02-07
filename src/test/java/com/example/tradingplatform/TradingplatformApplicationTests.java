package com.example.tradingplatform;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tradingplatform.Mapper.*;
import com.example.tradingplatform.Service.Impl.AddShopServicelmpl;
import com.example.tradingplatform.Service.Impl.RegistServiceImpl;
import com.example.tradingplatform.exception.AppExceptionCodeMsg;
import com.example.tradingplatform.pojo.Order;
import com.example.tradingplatform.pojo.Shop;
import com.example.tradingplatform.pojo.User;
import com.example.tradingplatform.response.Resp;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@SpringBootTest
class TradingplatformApplicationTests {
	@Autowired
	private AddShopServicelmpl addShopService;
	@Test
	void contextLoads(){
//		String number = "1648782294";
//		String password = "1";
//		User user1 = registMapper.selectOne(new QueryWrapper<User>()
//				.eq("user_number", number));
//		if (null != user1) {
//			System.out.println("该用户已存在");
//		} else {
//			User one = new User();
//			UUID uuid = UUID.randomUUID();
//			String strUUID = uuid.toString().replaceAll("-", "");
//			System.out.println("id为"+strUUID + "账号为:"+number + "密码为:" +password);
//			one.setId(strUUID);
//			one.setUserNumber(number);
//			one.setUserPassword(password);
//			registMapper.insert(one);
//			System.out.println("用户注册成功");
//		}
//		Page<Shop> shopPage = new Page<>(1,5);
//		IPage<Shop> shopIPage = shoppingMapper.selectPage(shopPage,null);
//		System.out.println("总页数:"+shopIPage.getPages());
//		System.out.println("总记录数:"+shopIPage.getTotal());
//		shopIPage.getRecords().forEach(System.out::println);
//		Shop shop = new Shop();
//		shop.setProductName("暂无");
//		shop.setProductDetial("暂无");
//		shop.setProductPrice(BigDecimal.valueOf(5));
//		shop.setProductPhoto("暂无");
//		shop.setProductCount(5);
//		ArrayList<Shop> shopList = new ArrayList<>();
//		for(int i = 0; i < shop.getProductCount(); i++){
//			//获取商品信息
//			Shop one = new Shop();
//			one.setProductName(shop.getProductName());
//			one.setProductPrice(shop.getProductPrice());
//			one.setProductPhoto(shop.getProductPhoto());
//			one.setProductDetial(shop.getProductDetial());
//			one.setProductCount(shop.getProductCount());
//			shopList.add(one);
//		}
//		int i = addShopMapper.addProductByUserId("a1e83f18e3874d6c9e31e36d2a7cf88b",shop);
//		System.out.println(i);
//		Shop shop = shopDetialMapper.selectByProductId(1);
//		System.out.println(JSON.toJSON(shop));
//		int i = addShopMapper.addProductByUserId("a1e83f18e3874d6c9e31e36d2a7cf88b",shop);
//		System.out.println(i);
//		Date date = new Date();
//		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//		System.out.println(dateFormat.format(date));
//		Order order = new Order();
//		order.setProductName("暂无");
//		order.setProductPrice(BigDecimal.valueOf(5));
//		order.setProductPhoto("暂无");
//		order.setProductCount(5);
//		order.setCreateTime(LocalDateTime.now());
//		orderMapper.addOrderByUserId("a1e83f18e3874d6c9e31e36d2a7cf88b",order);
//		System.out.println("success");
//		shopDetialMapper.updateShopByUserId("a1e83f18e3874d6c9e31e36d2a7cf88b",5);
//		shopDetialMapper.deleteShopByUserId("a1e83f18e3874d6c9e31e36d2a7cf88b");
//		String userNumber = "18332108918";
//		String userPassword = "18332108918abcd";
//		User user = new User();
//		UUID uuid = UUID.randomUUID();
//		String strUUID = uuid.toString().replaceAll("-", "");
//		user.setId(strUUID);
//		user.setUserNumber(userNumber);
//		user.setUserPassword(userPassword);
//		registService.insert(user);
//		String fileName = null;
//		Shop one = new Shop();
//		one.setProductName("暂无");
//		one.setProductPrice(BigDecimal.valueOf(99));
//		one.setProductDetial("暂无");
//		one.setProductCount(9);
//
//		if(!productPhoto.isEmpty()){
//			String originalFileName = productPhoto.getOriginalFilename();
//			String suffixName = originalFileName.substring(originalFileName.lastIndexOf('.'));
//			fileName = UUID.randomUUID().toString()+suffixName;
//			try{
//				productPhoto.transferTo(new File("C:\\Users\\ZC\\Pictures\\联想安卓照片//"+fileName));
//			}catch (IOException e) {
//				throw new RuntimeException(e);
//			}
//		}
//		one.setProductPhoto(fileName);
//		addShopService.addProductByUserId("ebdd515d83334ccf8851dfcb44790631",one);
	}
}
