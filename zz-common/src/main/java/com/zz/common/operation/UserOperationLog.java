/**
 * 文件名：UserOperation
 * 作者：张喆
 * 时间：2020/8/25 17:24
 * 描述：
 */

package com.zz.common.operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类名称:        UserOperation
 * 创建时间:      2020/8/25 17:24
 * 版本:          1.0
 * 说明:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOperationLog {
    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作时间
     */
    private Long startTime;

    /**
     * 消耗时间
     */
    private Integer spendTime;

    /**
     * 根路径
     */
    private String basePath;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private Object parameter;

    /**
     * 请求返回的结果
     */
    private Object result;

}
