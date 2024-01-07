package com.zjx.rbacredis.controller;

import com.zjx.rbacredis.entity.LoginUser;
import com.zjx.rbacredis.entity.User;
import com.zjx.rbacredis.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
public class IndexController {
    @Resource
    private UserService userService;
    @RequestMapping("hello")
    public String hello(){
        return "hello spring-boot";
    }

    /**
     * 登录接口
     * @param user
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<LoginUser> login(@RequestBody User user){
        LoginUser loginUser = null;
        try {
            loginUser = userService.login(user.getUsername(),user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok().body(loginUser);
    }

    /**
     * 登出接口
     * @return
     */
    @GetMapping("loginout")
    public ResponseEntity<String> loginOut(){
        userService.loginout();
        return ResponseEntity.ok().body("Success login out!");
    }

}
