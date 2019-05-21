package com.xw.ssm.dao;

import com.xw.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {
    @Insert("insert into t_xw_s_log(VISIT_TIME,USER_NAME,IP,URL,EXECUTION_TIME,METHOD) VALUES(#{visitTime},#{userName},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    @Select("select ID id,VISIT_TIME visitTime,USER_NAME userName,IP ip,URL url,EXECUTION_TIME executionTime,METHOD method from t_xw_s_log")
    List<SysLog> findAll();
}
