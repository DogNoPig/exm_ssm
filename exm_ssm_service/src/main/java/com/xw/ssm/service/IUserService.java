package com.xw.ssm.service;

import com.xw.ssm.domain.UserInfo;

import java.util.List;

public interface IUserService {
    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll();
}
