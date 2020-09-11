/**
 * 文件名：Init
 * 作者：张喆
 * 时间：2020/7/31 16:37
 * 描述：
 */

package com.zz.two.controller;

import com.zz.common.result.Result;
import com.zz.common.result.ResultUtil;
import com.zz.two.entity.User;
import com.zz.two.service.InitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目名称:     com-client-two
 * 类名称:       Init
 * 创建时间:     2020/7/31 16:37
 * 版本:         1.0
 */
@RestController
@Api(tags = "InitController", value = "微服务文档测试")
public class Init {
    @Autowired
    InitService initService;

    @ApiOperation("微服务一")
    @GetMapping("/haha")
    public Result init(){
        System.out.println("成功进入1");
        return ResultUtil.success();
    }


    @ApiOperation("微服务2")
    @GetMapping("/hehe")
    @ResponseBody
    public List<User> query(){
        System.out.println("成功进入2");
        return initService.query();
    }
}
