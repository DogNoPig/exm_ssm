package com.xw.ssm.dao;

import com.xw.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    //查询所有的产品信息
    @Select("select PRODUCT_NUM as productNum,PRODUCT_NAME as productName,CITY_NAME as cityName,DEPARTURE_TIME as departureTime,PRODUCT_PRICE as productPrice,PRODUCT_DESC as productDesc,PRODUCT_STATUS as productStatus from t_xw_product")
    List<Product> findAll() throws Exception;
    //保存新的产品信息
    @Insert("insert into t_xw_product(PRODUCT_NUM,PRODUCT_NAME,CITY_NAME,DEPARTURE_TIME,PRODUCT_PRICE,PRODUCT_DESC,PRODUCT_STATUS) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
