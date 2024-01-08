package com.zjx.rbacredis.service;

import com.zjx.rbacredis.entity.LoginUser;
import com.zjx.rbacredis.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface UserService {
    LoginUser login(String userName, String password) throws IOException;

    void loginout();

    HashMap<String, List<String>> getInfo();

    User getUser(int userId);
}
