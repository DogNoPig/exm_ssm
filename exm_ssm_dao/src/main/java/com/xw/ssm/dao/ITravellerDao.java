package com.xw.ssm.dao;

import com.xw.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("SELECT ID id,`NAME` `name`,SEX sex,PHONE_NUM phoneNum,CREDENTIALS_TYPE credentialsType,CREDENTIALS_NUM credentialsNum,TRAVELLER_TYPE travellerType from t_xw_passenger p WHERE p.ID IN (SELECT op.PASSENGER_ID FROM t_xw_order_passenger op WHERE op.ORDER_ID = #{ordersId})")
    List<Traveller> findByOrdersId(Integer ordersId) throws Exception;
}
