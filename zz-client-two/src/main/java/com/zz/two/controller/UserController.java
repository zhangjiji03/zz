/**
 * 文件名：Init
 * 作者：张喆
 * 时间：2020/7/31 16:37
 * 描述：
 */

package com.zz.two.controller;

import com.zz.common.result.Result;
import com.zz.two.entity.User;
import com.zz.two.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:     com-client-two
 * 类名称:       Init
 * 创建时间:     2020/7/31 16:37
 * 版本:         1.0
 */
@RestController
@Api(tags = "UserController", value = "微服务文档测试")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("用户登录接口")
    @GetMapping("/login")
    public Result init(@RequestBody User user){
        return userService.login(user);
    }


    @ApiOperation("用户退出接口")
    @GetMapping("/logout")
    @ResponseBody
    public Result query(){
        return userService.query();
    }
}
