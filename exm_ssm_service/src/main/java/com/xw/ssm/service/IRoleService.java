package com.xw.ssm.service;

import com.xw.ssm.domain.Permission;
import com.xw.ssm.domain.Role;

import java.util.List;

/**
 * 角色service层
 */
public interface IRoleService {
    /**
     * 查询所有角色信息
     * @return
     */
    List<Role> findAll();

    /**
     * 新建角色信息
     * @param role
     */
    void save(Role role);

    /**
     * 通过角色ID查询角色信息
     * @param roleId
     * @return
     */
    Role findById(Integer roleId);

    /**
     * 查询该角色尚未拥有的权限信息
     * @param roleId
     * @return
     */
    List<Permission> findOtherPermission(Integer roleId);

    /**
     * 添加角色权限信息
     * @param roleId
     * @param permissionIds
     */
    void addPermissionToRole(Integer roleId, Integer[] permissionIds);
}
