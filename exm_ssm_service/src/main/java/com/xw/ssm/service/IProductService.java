package com.xw.ssm.service;

import com.xw.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll() throws Exception;

    /**
     * 保存产品信息
     * @param product
     */
    void save(Product product);
}
