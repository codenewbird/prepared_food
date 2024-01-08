package com.zjx.rbacredis.exception;

public class HasNotRoleException extends RuntimeException {
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public HasNotRoleException(String notHavePermission) {
        System.out.println(notHavePermission);
    }
}
