package com.xw.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.xw.ssm.dao.IOrdersDao;
import com.xw.ssm.domain.Orders;
import com.xw.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xw
 * @date 2019-05-14 22:06
 */
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public Orders findById(Integer ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }

    @Override
    public List<Orders> findAllByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAll();
    }
}
