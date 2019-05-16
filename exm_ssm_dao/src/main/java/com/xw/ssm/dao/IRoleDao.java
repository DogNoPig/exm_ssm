package com.xw.ssm.dao;

import com.xw.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    /**
     * 根据用户id 查询该用户的所有id
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("SELECT ID id,ROLE_NAME roleName,ROLE_DESC roleDesc FROM t_xw_s_role WHERE ID IN (SELECT ROLE_ID FROM t_xw_s_user_role WHERE USER_ID = #{userId})")
    List<Role> findRoleByUserId(Integer userId)throws Exception;
}
