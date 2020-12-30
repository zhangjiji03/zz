/**
 * 文件名：InitImpl
 * 作者：张喆
 * 时间：2020/7/31 16:39
 * 描述：
 */

package com.zz.two.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zz.common.result.Result;
import com.zz.common.result.ResultUtil;
import com.zz.two.mapper.UserMapper;
import com.zz.two.entity.User;
import com.zz.two.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称:     com-client-two
 * 类名称:       InitImpl
 * 创建时间:     2020/7/31 16:39
 * 版本:         1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Result login( User user) {
        userMapper.insert(user);
        return  ResultUtil.success() ;
    }

    public Result logout() {
        return ResultUtil.success(userMapper.selectList(Wrappers.lambdaQuery()));
    }

}
