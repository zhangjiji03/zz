package com.zz.two.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.two.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * 项目名称:     com-client-two
 * 类名称:       InitMapper
 * 创建时间:     2020/7/31 16:40
 * 版本:         1.0
 */
@Mapper
public interface InitMapper  extends BaseMapper<User> {
    HashMap<String,Object> init();
}
