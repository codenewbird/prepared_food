package com.zjx.rbacredis.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zjx.rbacredis.configuration.CustomObjectMapper;
import com.zjx.rbacredis.configuration.RedisUtil;
import com.zjx.rbacredis.constant.Constant;
import com.zjx.rbacredis.entity.LoginUser;
import com.zjx.rbacredis.entity.Menu;
import com.zjx.rbacredis.entity.Role;
import com.zjx.rbacredis.entity.User;
import com.zjx.rbacredis.exception.PasswordIncorrectException;
import com.zjx.rbacredis.exception.UserNotFoundException;
import com.zjx.rbacredis.mapper.UserMapper;
import com.zjx.rbacredis.service.BaseService;
import com.zjx.rbacredis.service.UserService;
import com.zjx.rbacredis.util.CustomUtil;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private CustomObjectMapper objectMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public LoginUser login(String userName, String password) throws IOException {
        User user = userMapper.queryByUsername(userName);
        if(user == null) {
            throw new UserNotFoundException("执行登录操作：【"+userName+"】该用户不存在");
        }
        if (!password.equals(user.getPassword())){
            throw new PasswordIncorrectException("执行登录操作：【"+userName+"】该用户密码输入错误");
        }
        String token = UUID.randomUUID().toString();
        //获取request对象
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        UserAgent userAgent = new UserAgent(request.getHeader("User-Agent"));
        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://whois.pconline.com.cn/ipJson.jsp?ip="+request.getRemoteAddr()+"&json=true",String.class);
        String body = forEntity.getBody();
        Map<String,String> map = objectMapper.readValue(body,new TypeReference<Map<String,String>>(){

        });
        String location = map.get("addr") + map.get("pro") + map.get("city") + map.get("region");
        LoginUser loginUser = LoginUser.builder()
                .userId(user.getUserId())
                .token(token)
                .ipaddr(request.getRemoteAddr())
                .loginTime(new Date())
                .os(userAgent.getOperatingSystem().getName())
                .browser(userAgent.getBrowser().getName())
                .loginLocation(location)
                .user(user)
                .build();
        //key:name:uuid
        String keyPrefix = Constant.TOKEN_PREFIX+userName+":";
        Set<String> keys = (Set<String>) redisUtil.getKeyList(keyPrefix+"*");
        keys.stream().forEach(key ->{
            redisUtil.remove(key);
        });

        redisUtil.set(keyPrefix+token,loginUser, Constant.TOKEN_TTL);
        return loginUser;
    }

    @Override
    public void loginout() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader(Constant.HEAD_AUTHORIZATION);
        String username = request.getHeader("username");
        String tokenkey = Constant.TOKEN_PREFIX + username + ":" + token;
        redisUtil.remove(tokenkey);
    }

    @Override
    public HashMap<String, List<String>> getInfo() {
        LoginUser loginUser = getLoginUser();
        User user = userMapper.queryInfo(loginUser.getUserId());

        List<String> roleTags = user.getRoles().stream().map(Role::getRoleTag).collect(Collectors.toList());
        redisUtil.set(Constant.ROLE_PREFIX + loginUser.getToken(), roleTags,Constant.TOKEN_TTL);
        List<String> perms = new ArrayList<>();
        user.getRoles().stream().map(Role::getMenus).forEach(menus -> {
            perms.addAll(menus.stream().map(Menu::getPerms).collect(Collectors.toList()));
        });
        redisUtil.set(Constant.PERM_PREFIX + loginUser.getToken(), perms, Constant.TOKEN_TTL);
        HashMap<String,List<String>> info = new HashMap<>();
        info.put(Constant.ROLE_PREFIX,roleTags);
        info.put(Constant.PERM_PREFIX,perms);
        return info;
    }

    @Override
    public User getUser(int userId) {
        User user = userMapper.queryByUserId(userId);
        return user;
    }


}
