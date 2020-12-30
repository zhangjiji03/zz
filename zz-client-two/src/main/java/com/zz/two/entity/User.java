/**
 * 文件名：User
 * 作者：张喆
 * 时间：2020/7/31 17:17
 * 描述：
 */

package com.zz.two.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目名称:     com-client-two
 * 类名称:       User
 * 创建时间:     2020/7/31 17:17
 * 版本:         1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@ApiModel
public class User {
    @TableId("id")
    @ApiModelProperty(value = "id",required = true )
    Integer id;

    @TableField("username")
    @ApiModelProperty(value = "用户名",required = true )
    String username;

    @TableField("password")
    @ApiModelProperty(value = "",required = true)
    String password;

}
