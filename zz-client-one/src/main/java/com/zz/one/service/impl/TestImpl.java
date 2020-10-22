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
import com.zz.one.mapper.UserMapper;
import com.zz.one.service.TestSeervice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:     zz-client-one
 * 类名称:       TestImpl
 * 创建时间:     2020/7/31 17:54
 * 版本:         1.0
 */
@Service
public class TestImpl implements TestSeervice {
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> Init() {
        User user = User.builder().name("垃圾").age("10").build();
        userMapper.insert(user);
        return new ArrayList<>();
    }


    public Result ha(){
        List list=userMapper.selectList(Wrappers.lambdaQuery());
        return ResultUtil.success(list);
    }
}
