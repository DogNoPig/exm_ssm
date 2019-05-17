package com.xw.ssm.dao;

import com.xw.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    /**
     * 根据用户id 查询该用户的所有id
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM t_xw_s_role WHERE ID IN (SELECT ROLE_ID FROM t_xw_s_user_role WHERE USER_ID = #{userId})")
    @Results({
            @Result(id = true,column = "ID",property = "id"),
            @Result(column = "ROLE_NAME",property = "roleName"),
            @Result(column = "ROLE_DESC",property = "roleDesc"),
            @Result(column = "ID",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.xw.ssm.dao.IPermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUserId(Integer userId)throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    @Select("select ID id,ROLE_NAME roleName,ROLE_DESC roleDesc from t_xw_s_role")
    List<Role> findAll();

    @Insert("insert into t_xw_s_role(ROLE_NAME,ROLE_DESC) values(#{roleName},#{roleDesc})")
    void save(Role role);
}
