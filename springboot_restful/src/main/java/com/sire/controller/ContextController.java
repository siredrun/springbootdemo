package com.sire.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContextController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
