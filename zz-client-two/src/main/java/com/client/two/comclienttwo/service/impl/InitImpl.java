/**
 * 文件名：InitImpl
 * 作者：张喆
 * 时间：2020/7/31 16:39
 * 描述：
 */

package com.client.two.comclienttwo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.client.two.comclienttwo.controller.Init;
import com.client.two.comclienttwo.dao.InitMapper;
import com.client.two.comclienttwo.entity.User;
import com.client.two.comclienttwo.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
