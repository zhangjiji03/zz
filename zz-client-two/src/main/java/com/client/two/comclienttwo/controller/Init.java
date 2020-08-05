/**
 * 文件名：Init
 * 作者：张喆
 * 时间：2020/7/31 16:37
 * 描述：
 */

package com.client.two.comclienttwo.controller;

import com.client.two.comclienttwo.entity.User;
import com.client.two.comclienttwo.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 项目名称:     com-client-two
 * 类名称:       Init
 * 创建时间:     2020/7/31 16:37
 * 版本:         1.0
 */
@RestController
public class Init {
    @Autowired
    InitService initService;
    @GetMapping("/haha")
    public Map<String,Object> init(){
        System.out.println("成功进入1");
        return initService.init();
    }

    @GetMapping("/hehe")
    public List<User> query(){
        System.out.println("成功进入2");
        return initService.query();
    }
}
