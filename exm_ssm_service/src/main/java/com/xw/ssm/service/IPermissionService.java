package com.xw.ssm.service;

import com.xw.ssm.domain.Permission;

import java.util.List;

/**
 * 权限服务
 */
public interface IPermissionService {
    /**
     * 查询所有权限信息
     * @return
     */
    List<Permission> findAll();

    /**
     * 新建权限信息
     */
    void save(Permission permission);
}
