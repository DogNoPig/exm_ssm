package com.xw.ssm.service;

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
}
