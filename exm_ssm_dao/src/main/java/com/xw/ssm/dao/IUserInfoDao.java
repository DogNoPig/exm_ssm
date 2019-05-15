package com.xw.ssm.dao;

import com.xw.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserInfoDao {
    /**
     * 查看所有用户信息
     * @return
     */
    @Select("select ID id,EMAIL email,USER_NAME userName,PASSWORD password,PHONE_NUM phoneNum,STATUS status from t_xw_s_user")
    List<UserInfo> findAll();
}
