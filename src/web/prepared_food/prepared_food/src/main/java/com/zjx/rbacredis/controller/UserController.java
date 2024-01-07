package com.zjx.rbacredis.controller;

import com.zjx.rbacredis.annotation.HasPermission;
import com.zjx.rbacredis.annotation.HasRole;
import com.zjx.rbacredis.entity.User;
import com.zjx.rbacredis.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Resource
    private UserService userService;

    /**
     * 获取权限和角色信息
     * @return
     */
    @GetMapping("getInfo")
    public HashMap<String,List<String>> getperm(){
        HashMap<String, List<String>> info = userService.getInfo();
        return ResponseEntity.ok().body(info).getBody();
    }
//    @HasRole("admin")
    @GetMapping("{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok().body(user);
    }

//    @HasPermission("system:user")
    @GetMapping("/perm/{userId}")
    public ResponseEntity<User> getUser2(@PathVariable("userId") int userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok().body(user);
    }
}
