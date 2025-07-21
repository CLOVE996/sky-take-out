package com.sky.controller.admin;


import com.sky.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "店铺相关接口")
@RestController("adminShopController")
@RequestMapping("/admin/shop")
public class ShopController {

    @Autowired
    StringRedisTemplate redisTemplate;

    public static final String SHOP_STATUS = "SHOP_STATUS";

    @PutMapping("/{status}")
    public Result setStatus(@PathVariable Integer status) {
        log.info("设置店铺营业状态:{}",status == 1?"营业中":"打烊中");
        redisTemplate.opsForValue().set(SHOP_STATUS,status+"");
        return Result.success();
    }

    @GetMapping("/status")
    public Result getStatus() {
        String shopStatus = redisTemplate.opsForValue().get(SHOP_STATUS);
        log.info("获取店铺营业状态:{}",shopStatus);
        return Result.success(Integer.parseInt(shopStatus));
    }
}
