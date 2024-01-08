package com.zjx.rbacredis.controller;

import com.zjx.rbacredis.annotation.HasPermission;
import com.zjx.rbacredis.configuration.RedisConfig;
import com.zjx.rbacredis.configuration.RedisUtil;
import com.zjx.rbacredis.constant.Constant;
import com.zjx.rbacredis.entity.LoginUser;
import com.zjx.rbacredis.util.CustomUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

public class BaseController {

    @Resource
    private RedisUtil redisUtil;

    /**
     * 根据request中的token获取存储在Redis中的登录用户信息
     * @return
     */
    public LoginUser getLoginUser(){
        HttpServletRequest request = CustomUtil.getRequest();
        String token = request.getHeader(Constant.HEAD_AUTHORIZATION);
        String username = request.getHeader("username");
        String tokenKey = Constant.TOKEN_PREFIX + username + ":" + token;
        if(token == null){
            throw new RuntimeException("current user don't login");
        }
        //3.使用token去redis中查看有没有对应的user
        LoginUser user = (LoginUser) redisUtil.get(tokenKey);
        if(user == null){
            throw new RuntimeException("current user's login has expired");
        }
        return user;
    }

}
