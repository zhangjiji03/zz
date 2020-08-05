/**
 * 文件名：ResultUtil
 * 作者：张喆
 * 时间：2020/8/4 17:11
 * 描述：
 */

package com.zz.common.result;

/**
 * 项目名称:     zz-common
 * 类名称:       ResultUtil
 * 创建时间:     2020/8/4 17:11
 * 版本:         1.0
 */
public class ResultUtil {

    public static Result success(){
        return new Result(ResultStateEnum.SUCCESS.getCode(),ResultStateEnum.SUCCESS.getMessage(),null,String.valueOf(System.currentTimeMillis()));
    }

    public static Result success(Object data){
        return new Result(ResultStateEnum.SUCCESS.getCode(),ResultStateEnum.SUCCESS.getMessage(),data,String.valueOf(System.currentTimeMillis()));
    }

    public static Result success(String message){
        return new Result(ResultStateEnum.SUCCESS.getCode(),message,null,String.valueOf(System.currentTimeMillis()));
    }

    public static Result success(String message,Object data){
        return new Result(ResultStateEnum.SUCCESS.getCode(),message,data,String.valueOf(System.currentTimeMillis()));
    }

    public static Result error(){
        return new Result(ResultStateEnum.ERROR.getCode(),ResultStateEnum.ERROR.getMessage(),null,String.valueOf(System.currentTimeMillis()));
    }

    public static Result error(String message){
        return new Result(ResultStateEnum.ERROR.getCode(),message,null,String.valueOf(System.currentTimeMillis()));
    }

    public static Result common(int code,String message,Object data){
        return new Result(code,message,data,String.valueOf(System.currentTimeMillis()));
    }
}
