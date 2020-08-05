package com.zz.two.service;

import com.zz.two.entity.User;

import java.util.HashMap;
import java.util.List;

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
