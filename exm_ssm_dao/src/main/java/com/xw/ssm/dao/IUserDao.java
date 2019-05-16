package com.xw.ssm.dao;

import com.xw.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface IUserDao {

    @Select("select ID id,EMAIL email,USER_NAME userName,PASSWORD password,PHONE_NUM phoneNum,STATUS status from t_xw_s_user where USER_NAME = #{userName}")
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
}
