package com.xw.ssm.dao;

import com.xw.ssm.domain.Member;
import com.xw.ssm.domain.Orders;
import com.xw.ssm.domain.Product;
import com.xw.ssm.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    /**
     * 通过订单id查询订单信息
     * @param ordersId
     * @return
     */
     @Select("select * from t_xw_order where ID = #{ordersId}")
    @Results({
            @Result(id=true,column = "ID",property = "id"),
            @Result(column = "ORDER_NUM",property = "orderNum"),
            @Result(column = "ORDER_TIME",property = "orderTime"),
            @Result(column = "ORDER_STATUS",property = "orderStatus"),
            @Result(column = "PEOPLE_COUNT",property = "peopleCount"),
            @Result(column = "PAY_TYPE",property = "payType"),
            @Result(column = "ORDER_DESC",property = "orderDesc"),
            @Result(column = "PRODUCT_ID",property = "product",javaType = Product.class,one = @One(select = "com.xw.ssm.dao.IProductDao.findById")),
            @Result(column = "MEMBER_ID",property = "member",javaType = Member.class,one = @One(select = "com.xw.ssm.dao.IMemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select = "com.xw.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(Integer ordersId) throws Exception;

    @Select("select * from t_xw_order")
    @Results({
            @Result(id=true,column = "ID",property = "id"),
            @Result(column = "ORDER_NUM",property = "orderNum"),
            @Result(column = "ORDER_TIME",property = "orderTime"),
            @Result(column = "ORDER_STATUS",property = "orderStatus"),
            @Result(column = "PEOPLE_COUNT",property = "peopleCount"),
            @Result(column = "PAY_TYPE",property = "payType"),
            @Result(column = "ORDER_DESC",property = "orderDesc"),
            @Result(column = "PRODUCT_ID",property = "product",javaType = Product.class,one = @One(select = "com.xw.ssm.dao.IProductDao.findById")),
            @Result(column = "MEMBER_ID",property = "member",javaType = Member.class,one = @One(select = "com.xw.ssm.dao.IMemberDao.findById"))
    })
    List<Orders> findAll();
}
