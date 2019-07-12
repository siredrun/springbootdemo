package com.sire.mvc;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 表明这是一个配置类
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    // 所有的WebMvcConfigurerAdapter组件一起起作用
    @Bean// 将组件注册到容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // super.addViewControllers(registry);
                // 拦截请求并转发到相应页面
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
            }
        };
    }
}
