package com.xw.ssm.service;

import com.xw.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    /**
     * 保存日志信息
     * @param sysLog
     */
    void save(SysLog sysLog);

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<SysLog> findAllByPage(Integer page, Integer pageSize);
}
