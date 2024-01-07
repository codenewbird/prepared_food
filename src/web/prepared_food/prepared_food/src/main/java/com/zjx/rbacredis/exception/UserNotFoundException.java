package com.zjx.rbacredis.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String s){
        System.out.println(s);
    }
}
