package com.ratel.json.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @业务描述：
 * @package_name： com.ratel.json.entity
 * @project_name： fast-json-test
 * @author： ratelfu@qq.com
 * @create_time： 2019-09-17 17:15
 * @copyright (c) ratelfu 版权所有
 */
@Data
@ApiModel
@AllArgsConstructor
public class User {
    /**
     *用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     *用户密码
     */
    @ApiModelProperty("用户密码")
    private  String password;

}
