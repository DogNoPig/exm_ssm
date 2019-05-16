package com.xw.ssm.service;

import com.xw.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    /**
     * 保存系统用户信息
     * @param userInfo
     */
    void save(UserInfo userInfo);
}
