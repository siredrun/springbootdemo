package com.sire.mvc;

import com.sire.component.LoginHandlerIntercepter;
import com.sire.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 表明这是一个配置类
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    // 让自定义LocaleResolver生效
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    // 所有的WebMvcConfigurerAdapter组件一起起作用
    @Bean// 将组件注册到容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 拦截请求并转发到相应页面
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 注册登录拦截器
//                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login"
//                                ,"/asserts/**","/webjars/**");
            }
        };
        return adapter;
    }
}
