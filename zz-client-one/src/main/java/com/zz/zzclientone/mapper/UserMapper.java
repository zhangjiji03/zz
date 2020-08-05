/**
 * 文件名：TestMapper
 * 作者：张喆
 * 时间：2020/7/31 17:49
 * 描述：
 */

package com.zz.zzclientone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.zzclientone.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目名称:     zz-client-one
 * 类名称:       TestMapper
 * 创建时间:     2020/7/31 17:49
 * 版本:         1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
