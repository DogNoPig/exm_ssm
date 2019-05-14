package com.xw.ssm.service;

import com.xw.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    /**
     * 通过id查询订单详情
     * @param ordersId
     * @return
     */
    Orders findById(Integer ordersId) throws Exception;

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<Orders> findAllByPage(Integer page, Integer pageSize);
}
