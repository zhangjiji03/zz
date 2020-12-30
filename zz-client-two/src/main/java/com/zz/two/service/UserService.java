package com.zz.two.service;

import com.zz.common.result.Result;
import com.zz.two.entity.User;

/**
 * 项目名称:     com-client-two
 * 类名称:       InitService
 * 创建时间:     2020/7/31 16:38
 * 版本:         1.0
 */
public interface UserService {
    Result login( User user);
    Result logout();
}
