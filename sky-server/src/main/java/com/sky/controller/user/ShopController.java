package com.sky.controller.user;


import com.sky.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "店铺相关接口")
@RestController("userShopController")
@RequestMapping("/user/shop")
public class ShopController {

    @Autowired
    StringRedisTemplate redisTemplate;

    public static final String SHOP_STATUS = "SHOP_STATUS";
    @GetMapping("/status")
    public Result getStatus() {
        String shopStatus = redisTemplate.opsForValue().get(SHOP_STATUS);
        log.info("获取店铺营业状态:{}", shopStatus);
        return Result.success(Integer.parseInt(shopStatus));
    }
}
