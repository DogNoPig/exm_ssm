package com.xw.ssm.dao;

import com.xw.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {


    @Select("select ID id,PERMISSION_NAME permissionName,URL url from t_xw_s_permission where ID IN (SELECT PERMISSION_ID FROM t_xw_s_role_permission where ROLE_ID = #{roleId})")
    List<Permission> findByRoleId(Integer roleId);

    /**
     * 查询所有权限信息
     * @return
     */
    @Select("select ID id,PERMISSION_NAME permissionName,URL url from t_xw_s_permission")
    List<Permission> findAll();

    /**
     * 新建权限
     * @param permission
     */
    @Insert("insert into t_xw_s_permission(PERMISSION_NAME,URL) VALUES(#{permissionName},#{url})")
    void save(Permission permission);
}
