/**
 * 文件名：TestSeervice
 * 作者：张喆
 * 时间：2020/7/31 17:53
 * 描述：
 */

package com.zz.one.service;

import com.zz.common.result.Result;
import com.zz.one.entity.User;

import java.util.List;

/**
 * 项目名称:     zz-client-one
 * 类名称:       TestSeervice
 * 创建时间:     2020/7/31 17:53
 * 版本:         1.0
 */
public interface TestSeervice {
    List<User> Init();
    Result ha();
}
