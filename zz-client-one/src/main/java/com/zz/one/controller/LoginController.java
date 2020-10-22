/**
 * 文件名：LoginController
 * 作者：张喆
 * 时间：2020/8/3 18:25
 * 描述：
 */

package com.zz.one.controller;

import com.zz.common.result.Result;
import com.zz.common.result.ResultUtil;
import com.zz.one.entity.User;
import com.zz.one.feign.FeignService;
import com.zz.one.mapper.UserMapper;
import com.zz.one.service.TestSeervice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:     zz-client-one
 * 类名称:       LoginController
 * 创建时间:     2020/8/3 18:25
 * 版本:         1.0
 */
@RestController
@Api(tags = "LoginController", value = "用户登录")
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserMapper userMapper;

    @Autowired
    FeignService feignService;

    @Autowired
    TestSeervice TestSeervice;

    @GetMapping("/login")
    @ApiOperation("用户登录接口")
    public String login(){
        TestSeervice.Init();
        return  "haha";
    }

    @GetMapping("/ha")
    public Result ha(){
        return TestSeervice.ha();
    }

    @PostMapping("/logout")
    @ApiOperation("用户退出接口")
    public Result logout(@RequestBody User userParam){
        return ResultUtil.success();
    }

    @GetMapping("/test")
    public Result jij(){
        Result result=feignService.get();
        return result;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
