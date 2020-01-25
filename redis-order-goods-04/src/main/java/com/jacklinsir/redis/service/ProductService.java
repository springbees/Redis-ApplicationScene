package com.jacklinsir.redis.service;

import com.jacklinsir.redis.model.Product;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/24 13:29
 */
public interface ProductService {

    int addProduct(Product product);

    List<Product> getHistoryProducts(Integer userId);
}
