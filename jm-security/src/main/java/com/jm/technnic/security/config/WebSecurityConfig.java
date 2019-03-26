package com.jm.technnic.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity//开启WebSecurity功能
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法上的保护
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //不需要验证的资源
                .antMatchers("/css/**", "/index").permitAll()
                //需要验证，角色为Role
                .antMatchers("/article/**").hasAnyRole("ADMIN","STUDENT","TEACHER")
                .antMatchers("/admin/**").hasAnyRole("ADMIN","STUDENT","TEACHER")
                .and()
                //表单的登录地址和失败地址
                .formLogin().loginPage("/login").failureForwardUrl("/loginError")
                .and()
                //异常处理界面
                .exceptionHandling().accessDeniedPage("/401");
        http.logout().logoutSuccessUrl("/");
    }
}
