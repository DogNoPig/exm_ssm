package com.xw.ssm.service;

import com.xw.ssm.domain.Role;
import com.xw.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    /**
     * 保存系统用户信息
     * @param userInfo
     */
    void save(UserInfo userInfo);

    /**
     * 获取用户详细信息
     * @param id
     * @return
     */
    UserInfo findById(Integer id);

    /**
     * 获取该用户尚未拥有的角色
     * @param id
     * @return
     */
    List<Role> findOtherRole(Integer id);

    /**
     * 为用户添加角色
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(Integer userId, Integer[] roleIds);
}
