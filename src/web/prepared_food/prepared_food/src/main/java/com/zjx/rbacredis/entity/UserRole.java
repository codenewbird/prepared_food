package com.zjx.rbacredis.entity;

import java.io.Serializable;

/**
 * 用户和角色关联表(UserRole)实体类
 *
 * @author makejava
 * @since 2023-08-29 17:17:31
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = 782506052009343058L;
/**
     * 用户ID
     */
    private Long userId;
/**
     * 角色ID
     */
    private Long roleId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}

