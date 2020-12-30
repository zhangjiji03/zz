/**
 * 文件名：TestImpl
 * 作者：张喆
 * 时间：2020/7/31 17:54
 * 描述：
 */

package com.zz.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zz.common.result.Result;
import com.zz.common.result.ResultUtil;
import com.zz.one.entity.User;
import com.zz.one.feign.FeignService;
import com.zz.one.mapper.UserMapper;
import com.zz.one.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称:     zz-client-one
 * 类名称:       TestImpl
 * 创建时间:     2020/7/31 17:54
 * 版本:         1.0
 */
@Slf4j
@Service
public  class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    FeignService feignService;


    @Override
    public Result login() {
        User user = User.builder().username("垃圾").password("10").build();
        userMapper.insert(user);
        return ResultUtil.success();
    }

    @Override
    public Result logout(){
        log.warn("测试收集日志");
        List list=userMapper.selectList(Wrappers.lambdaQuery());
        log.info(list.toString());
        return ResultUtil.success(list);
    }

    @Override
    @GlobalTransactional
    public Result test(User user){
        log.info(user.toString());
        userMapper.insert(user);
        feignService.get(user);
        return ResultUtil.success();
    }
}
