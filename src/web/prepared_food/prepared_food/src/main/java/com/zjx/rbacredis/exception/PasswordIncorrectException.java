package com.zjx.rbacredis.exception;

public class PasswordIncorrectException extends RuntimeException {
    public PasswordIncorrectException(String s) {
        System.out.println(s);
    }
}
