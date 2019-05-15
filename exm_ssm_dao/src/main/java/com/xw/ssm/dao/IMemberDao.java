package com.xw.ssm.dao;

import com.xw.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select ID id,NAME name,NICK_NAME nickName,PHONE_NUM phoneNum,EMAIL email from t_xw_vip_user where ID = #{id}")
    Member findById(Integer id) throws Exception;
}
