package com.xw.ssm.service.impl;

import com.xw.ssm.dao.IRoleDao;
import com.xw.ssm.domain.Role;
import com.xw.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色实现类
 * @author xw
 * @date 2019/5/17 15:18
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
