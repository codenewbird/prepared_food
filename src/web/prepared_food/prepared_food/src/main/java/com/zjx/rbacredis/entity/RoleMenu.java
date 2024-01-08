package com.zjx.rbacredis.entity;

import java.io.Serializable;

/**
 * 角色和菜单关联表(RoleMenu)实体类
 *
 * @author makejava
 * @since 2023-08-29 17:17:27
 */
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 719649070145163827L;
/**
     * 角色ID
     */
    private Long roleId;
/**
     * 菜单ID
     */
    private Long menuId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}

