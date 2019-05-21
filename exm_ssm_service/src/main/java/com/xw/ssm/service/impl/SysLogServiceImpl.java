package com.xw.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.xw.ssm.dao.ISysLogDao;
import com.xw.ssm.domain.SysLog;
import com.xw.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 日志服务类
 * @author xw
 * @date 2019/5/21 9:40
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAllByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return sysLogDao.findAll();
    }
}
