package com.ratel.json.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ratel.json.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @业务描述：
 * @package_name： com.ratel.json.controller
 * @project_name： fast-json-test
 * @author： ratelfu@qq.com
 * @create_time： 2019-09-17 17:34
 * @copyright (c) ratelfu 版权所有
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户相关的controller")
public class UserController {

    @ApiOperation("保存")
    @PostMapping("/save")
    public  boolean save(@RequestBody String jsonString){
        //方法一
        //将前端传过来的json字符串转换为map
        Map map = JSONObject.parseObject(jsonString, Map.class);
        System.out.println(map);
        //获取前端传过来的第一个list
        String list1 = map.get("list1").toString();
        List<User> objects = JSON.parseArray(list1,User.class);
        for (User object : objects) {
            System.out.println(object);
        }
        //获取前端传过来的第二个list
        String list2 = map.get("list2").toString();
        List<User> objects1 = JSON.parseArray(list2,User.class);
        for (User object : objects1) {
            System.out.println(object);
        }
        //方法二
        System.out.println("=========================");
        Map map1 = JSON.parseObject(jsonString, Map.class);
        System.out.println(map1);
        //User user = JSON.parseObject(jsonString, User.class);
       // System.out.println(user);
        //jsonToList(jsonString,User.class);
        return true;
    }

    @ApiOperation("保存用户")
    @PostMapping("/saveUser")
    public boolean saveUser(@RequestBody User user){
        System.out.println(user);
        return  true;
    }

    @ApiOperation(value = "获取用户", notes = "根据输入的用户名和密码获取用户")
    @GetMapping("/getUser")
    @ApiImplicitParams({
                            //name的值和方法请求参数的名字一样否则在swagger中会出现多个参数
            @ApiImplicitParam(name = "userName", value = "用户名啊", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "用户密码啊", required = false, dataType = "String", paramType = "query")
    })
    public User getUser(@RequestParam String userName,@RequestParam String password){
       return  new User(userName,password);
    }
    /**
     * 将list类型的json字符串转为list
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        List<T> offList = JSONObject.parseArray(jsonString, clazz);
        return offList;
    }
}
