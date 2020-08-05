/**
 * 文件名：Exception
 * 作者：张喆
 * 时间：2020/8/4 16:24
 * 描述：
 */

package com.zz.error;

import com.zz.result.Result;
import com.zz.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 项目名称:     zz-common
 * 类名称:       Exception
 * 创建时间:     2020/8/4 16:24
 * 版本:         1.0
 */
@Slf4j
@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        log.info(e.getMessage());
        return ResultUtil.error("服务出现异常");
    }
}
