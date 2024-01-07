package com.zjx.rbacredis.constant;

public class Constant {
    //统一的token前缀
    public static final String TOKEN_PREFIX = "token:";
    //前端token的键名称
    public static final String HEAD_AUTHORIZATION = "Authorization";
    //Redis中token的存活时间
    public static final Long TOKEN_TTL = 30*60L;
    //角色前缀
    public static final String ROLE_PREFIX = "roles:";
    //权限前缀
    public static final String PERM_PREFIX = "menu:";
}
