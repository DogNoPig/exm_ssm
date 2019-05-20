package com.xw.ssm.dao;

import com.xw.ssm.domain.Role;
import com.xw.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IUserDao {

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     * @throws Exception
     */
    @Select("select * from t_xw_s_user where USER_NAME = #{userName}")
    @Results({
            @Result(id = true, property = "id", column = "ID"),
            @Result(property = "email", column = "EMAIL"),
            @Result(property = "userName", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "phoneNum", column = "PHONE_NUM"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "roles",column = "ID",javaType = java.util.List.class,many = @Many(select = "com.xw.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUserName(String userName) throws Exception;

    /**
     * 保存新建的用户信息
     * @param userInfo
     */
    @Insert("INSERT INTO t_xw_s_user(EMAIL,USER_NAME,PASSWORD,PHONE_NUM,STATUS) VALUES(#{email},#{userName},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("SELECT * FROM t_xw_s_user WHERE ID = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "ID"),
            @Result(property = "email", column = "EMAIL"),
            @Result(property = "userName", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "phoneNum", column = "PHONE_NUM"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "roles",column = "ID",javaType = java.util.List.class,many = @Many(select = "com.xw.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(Integer id);

    /**
     * 查询其他尚未拥有的角色
     * @param id
     * @return
     */
    @Select("select ID id,ROLE_NAME roleName,ROLE_DESC roleDesc FROM t_xw_s_role where ID NOT IN(SELECT ROLE_ID FROM t_xw_s_user_role where USER_ID = #{id})")
    List<Role> findOtherRole(Integer id);

    @Insert("INSERT INTO t_xw_s_user_role(USER_ID,ROLE_ID) VALUES(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId")Integer userId,@Param("roleId")Integer roleId);
}
