/**
 * 文件名：WebMvcConfig
 * 作者：张喆
 * 时间：2020/8/11 18:02
 * 描述：
 */

package com.zz.one.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 项目名称:     zz-client-two
 * 类名称:       WebMvcConfig
 * 创建时间:     2020/8/11 18:02
 * 版本:         1.0
 * 说明：
 */
@Configuration
public class WebMvcConfig  extends WebMvcConfigurationSupport {
    /*@Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/**");
        super.addInterceptors(registry);
    }
*/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
