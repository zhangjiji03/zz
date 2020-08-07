/**
 * 文件名：SecuritySecureConfig
 * 作者：张喆
 * 时间：2020/8/7 10:54
 * 描述：
 */

package com.zz.admin.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.UUID;

/**
 * 项目名称:     zz-client-two
 * 类名称:       SecuritySecureConfig
 * 创建时间:     2020/8/7 10:54
 * 版本:         1.0
 * 注释：        admin安全模块配置
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeRequests()
                //授予对所有静态资产和登录页面的公共访问权限。
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                //必须对每个其他请求进行身份验证
                .anyRequest().authenticated()
                .and()
                //	配置登录和注销。
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
                .logout().logoutUrl(adminContextPath + "/logout").and()
                //启用HTTP-Basic支持。这是Spring Boot Admin Client注册所必需的
                .httpBasic().and()
                .csrf()
                //使用Cookie启用CSRF保护
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers(
                        //禁用CRSF-Protection Spring Boot Admin Client用于注册的端点。
                        adminContextPath + "/instances",
                        adminContextPath + "/actuator/**"
                );
    }
}
