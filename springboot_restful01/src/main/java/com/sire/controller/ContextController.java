package com.sire.controller;

import com.sire.exception.UserException;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContextController {
    @RequestMapping("/hello")
    public String hello(@RequestParam("name")String name){
        // 使用自定义异常 测试定制异常页面
        if(name.equals("aaa")){
            throw new UserException();
        }
        return "hello world";
    }
}
