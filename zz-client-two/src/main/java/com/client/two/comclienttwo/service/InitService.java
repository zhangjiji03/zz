package com.client.two.comclienttwo.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.client.two.comclienttwo.entity.User;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称:     com-client-two
 * 类名称:       InitService
 * 创建时间:     2020/7/31 16:38
 * 版本:         1.0
 */
public interface InitService {
    HashMap<String,Object> init();
    List<User> query();
}
