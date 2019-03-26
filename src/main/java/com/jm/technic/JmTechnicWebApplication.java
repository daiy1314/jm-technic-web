package com.jm.technic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//可以用以下三个注解代替 SpringBootApplication
//@SpringBootConfiguration（Spring Boot 的配置注解）
//@EnableAutoConfiguration（自动配置）
//@ComponentScan（Spring Boot扫描 Bean 的规则，比如扫描哪些包）
@MapperScan(basePackages = {"com.jm.technic.mapper"})
@EnableCaching
public class JmTechnicWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JmTechnicWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JmTechnicWebApplication.class, args);
    }
}
