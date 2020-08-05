/**
 * 文件名：Result
 * 作者：张喆
 * 时间：2020/8/4 16:45
 * 描述：
 */

package com.zz.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目名称:     zz-common
 * 类名称:       Result
 * 创建时间:     2020/8/4 16:45
 * 版本:         1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    // 返回的状态码
    int code;
    // 返回的消息描述
    String message;
    // 返回的消息体
    Object data;
    // 返回当前时间戳
    String timestamp;
}
