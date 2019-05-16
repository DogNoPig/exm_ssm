package com.xw.ssm.dao;

import com.xw.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;


public interface IUserDao {

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

    @Insert("INSERT INTO t_xw_s_user(EMAIL,USER_NAME,PASSWORD,PHONE_NUM,STATUS) VALUES(#{email},#{userName},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);
}
