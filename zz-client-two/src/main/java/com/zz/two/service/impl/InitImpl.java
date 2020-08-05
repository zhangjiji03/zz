/**
 * 文件名：InitImpl
 * 作者：张喆
 * 时间：2020/7/31 16:39
 * 描述：
 */

package com.zz.two.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zz.two.dao.InitMapper;
import com.zz.two.entity.User;
import com.zz.two.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 项目名称:     com-client-two
 * 类名称:       InitImpl
 * 创建时间:     2020/7/31 16:39
 * 版本:         1.0
 */
@Service
public class InitImpl implements InitService {
    @Autowired
    InitMapper initMapper;

    @Override
    public HashMap<String,Object> init() {
        return  initMapper.init();
    }


    public List<User> query() {
         initMapper.selectList(Wrappers.lambdaQuery());
        return null;
    }

}
