/**
 * 文件名：SwaggerConfig
 * 作者：张喆
 * 时间：2020/8/25 11:33
 * 描述：
 */

package com.zz.one.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 项目名称:     zz-client-two
 * 类名称:       SwaggerConfig
 * 创建时间:     2020/8/25 11:33
 * 版本:         1.0
 * 说明：        Swagger2API文档的配置
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为有@Api注解的Controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.zz.one.controller"))
                //为有@ApiOperation注解的方法生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                //.paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ZZone项目接口文档")
                .description("ZZ项目接口文档")
                .contact("zhangzhe")
                .version("1.0")
                .build();
    }

}
