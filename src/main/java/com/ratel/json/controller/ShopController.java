package com.ratel.json.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @业务描述：
 * @package_name： com.ratel.json.controller
 * @project_name： fast-json-test
 * @author： ratelfu@qq.com
 * @create_time： 2019-09-18 16:04
 * @copyright (c) ratelfu 版权所有
 */
@RestController
@Api(description = "用于测试swagger的api分组功能")
@RequestMapping("/shop")
public class ShopController {


    @GetMapping("getShop/{shopId}/{shopName}")
    @ApiOperation("根据商品id和商品名称获取商品")
    @ApiImplicitParams({
            //name的值和方法请求参数的名字一样否则在swagger中会出现多个参数
            @ApiImplicitParam(name = "shopId", value = "商品id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "shopName", value = "商品名称", required = true, dataType = "String", paramType = "path")
    })
    public String getShop(@PathVariable String shopId, @PathVariable String shopName){
        return "商品id为："+shopId+"的商品名称为："+shopName;
    }

    @PostMapping("getShop/{shopId}/{shopName}")
    @ApiOperation("根据商品id和商品名称获取商品")
    @ApiImplicitParams({
            //name的值和方法请求参数的名字一样否则在swagger中会出现多个参数
            @ApiImplicitParam(name = "shopId", value = "商品id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "shopName", value = "商品名称", required = true, dataType = "String", paramType = "path")
    })
    public String getShop2(@PathVariable String shopId, @PathVariable String shopName){
        return "商品id为："+shopId+"的商品名称为："+shopName;
    }



}
