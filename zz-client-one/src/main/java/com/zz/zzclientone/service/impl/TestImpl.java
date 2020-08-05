/**
 * 文件名：TestImpl
 * 作者：张喆
 * 时间：2020/7/31 17:54
 * 描述：
 */

package com.zz.zzclientone.service.impl;

import com.zz.zzclientone.entity.User;
import com.zz.zzclientone.mapper.UserMapper;
import com.zz.zzclientone.service.TestSeervice;
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
}
