/**
 * 文件名：Test
 * 作者：张喆
 * 时间：2020/7/31 17:52
 * 描述：
 */

package com.zz.zzclientone.controller;

import com.zz.zzclientone.entity.User;
import com.zz.zzclientone.service.TestSeervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目名称:     zz-client-one
 * 类名称:       Test
 * 创建时间:     2020/7/31 17:52
 * 版本:         1.0
 */
@RestController
public class Test {
    @Autowired
    TestSeervice testSeervice;
    @GetMapping("/test")
    public List<User> Init(){
        System.out.println("one成功进入");
        return testSeervice.Init();
    }
}
