package com.xw.ssm.service;

import com.xw.ssm.domain.UserInfo;

import java.util.List;

public interface IUserInfoService {
    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 保存新建用户的信息
     * @param userInfo
     */
    void save(UserInfo userInfo);
}
