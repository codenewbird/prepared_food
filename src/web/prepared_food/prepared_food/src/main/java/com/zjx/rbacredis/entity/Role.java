package com.zjx.rbacredis.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 角色信息表(Role)实体类
 *
 * @author makejava
 * @since 2023-08-29 17:17:27
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 354676663940322096L;
/**
     * 角色ID
     */
    private Long roleId;
/**
     * 角色名称
     */
    private String roleName;
/**
     * 角色标签
     */
    private String roleTag;
/**
     * 显示顺序
     */
    private Integer roleSort;
/**
     * 角色状态（0正常 1停用）
     */
    private String status;
/**
     * 创建者
     */
    private String createBy;
/**
     * 创建时间
     */
    private Date createTime;
/**
     * 更新者
     */
    private String updateBy;
/**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 角色拥有的权限
     */
    private List<Menu> menus;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}

