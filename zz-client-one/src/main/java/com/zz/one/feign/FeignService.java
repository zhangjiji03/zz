package com.zz.one.feign;

import com.zz.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类名称:        service
 * 创建时间:      2020/9/14 10:36
 * 版本:          1.0
 * 说明:
 */
@FeignClient(value = "two")
public interface FeignService {
    @GetMapping("/haha")
    Result get();
}
