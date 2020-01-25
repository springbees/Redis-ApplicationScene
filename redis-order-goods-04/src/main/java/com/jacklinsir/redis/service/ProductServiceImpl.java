package com.jacklinsir.redis.service;

import com.jacklinsir.redis.component.RedisListService;
import com.jacklinsir.redis.dao.ProductDao;
import com.jacklinsir.redis.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/24 13:30
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private RedisListService redisListService;

    /**
     * 获取历史商品
     *
     * @param userId
     * @return
     */
    @Override
    public List<Product> getHistoryProducts(Integer userId) {
        List<Product> historyProducts = redisListService.getHistoryProducts(userId);
        return historyProducts.size() > 0 ? historyProducts : Collections.EMPTY_LIST;
    }

    @Override
    public int addProduct(Product product) {

        if (product != null) {
            product.setId(null);
            //将商品塞入数据库中
            int addProduct = productDao.addProduct(product);
            //保证数据双写一致性，先确保数据库插入成功在插入redis中
            if (addProduct > 0) {
                productDao.addProduct(product);
                //获取商品返回ID
                Integer id = product.getId();
                if (id > 0) {
                    redisListService.pushRedisService(product);
                }
                return id;
            }
        }
        return 0;
    }


}
