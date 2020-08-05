/**
 * 文件名：LoginController
 * 作者：张喆
 * 时间：2020/8/3 18:25
 * 描述：
 */

package com.zz.one.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zz.common.result.Result;
import com.zz.common.result.ResultUtil;
import com.zz.one.entity.User;
import com.zz.one.mapper.UserMapper;
import com.zz.one.util.RedisKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 项目名称:     zz-client-one
 * 类名称:       LoginController
 * 创建时间:     2020/8/3 18:25
 * 版本:         1.0
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public Result login(@RequestBody User userParam){
        String token = JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis()))  //设置过期时间
                .withAudience("user1") //设置接受方信息，一般时登录用户
                .sign(Algorithm.HMAC256("111111"));

        System.out.println(token);
        User user=userMapper.selectOne(Wrappers.lambdaQuery(userParam));
        if(user!=null){
            redisTemplate.opsForValue().set(RedisKeys.user_info_key+token, user);
            return ResultUtil.success(token);
        }else{
            redisTemplate.opsForValue().set(RedisKeys.user_info_key, user);
            return ResultUtil.error("失败");
        }
    }

    @PostMapping("/logout")
    public Result logout(@RequestBody User userParam){
        redisTemplate.delete(RedisKeys.user_info_key);
        return ResultUtil.success();
    }
}
