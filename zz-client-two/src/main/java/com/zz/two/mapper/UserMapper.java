package com.zz.two.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.common.result.Result;
import com.zz.two.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目名称:     com-client-two
 * 类名称:       InitMapper
 * 创建时间:     2020/7/31 16:40
 * 版本:         1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    Result login(User user);
}
