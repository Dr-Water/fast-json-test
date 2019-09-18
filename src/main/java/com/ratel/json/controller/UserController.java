package com.ratel.json.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ratel.json.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Map map = JSONObject.parseObject(jsonString, Map.class);
        System.out.println(map);
        String list1 = map.get("list1").toString();
        List<User> objects = JSON.parseArray(list1,User.class);
        for (User object : objects) {
            System.out.println(object);
        }
        String list2 = map.get("list2").toString();
        List<User> objects1 = JSON.parseArray(list2,User.class);
        for (User object : objects1) {
            System.out.println(object);
        }

        System.out.println("=========================");
        Map map1 = JSON.parseObject(jsonString, Map.class);
        System.out.println(map1);
        //User user = JSON.parseObject(jsonString, User.class);
       // System.out.println(user);
        //jsonToList(jsonString,User.class);
        return true;
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
