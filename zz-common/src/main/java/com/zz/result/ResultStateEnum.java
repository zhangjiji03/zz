package com.zz.result;

import lombok.*;

/**
 * 项目名称:     zz-common
 * 类名称:       ResultStateEnum
 * 创建时间:     2020/8/4 16:59
 * 版本:         1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultStateEnum {

    SUCCESS(200,"success"),
    ERROR(400,"error");

    // 返回的状态码
    int code;
    // 返回的消息描述
    String message;

}
