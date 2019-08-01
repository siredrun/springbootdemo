package com.sire.controller;

import com.sire.exception.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "1234".equals(password)){
            session.setAttribute("userLogin",username);
            System.out.println("登录成功");
            // 登录成功 防止表单重复提交,重定向到主页
            return "redirect:/main.html";
        }else {
            // 登录失败
            System.out.println("登录失败");
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
