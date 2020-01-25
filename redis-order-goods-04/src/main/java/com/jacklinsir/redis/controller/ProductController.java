package com.jacklinsir.redis.controller;

import com.jacklinsir.redis.model.Product;
import com.jacklinsir.redis.result.CommonResults;
import com.jacklinsir.redis.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品controller
 *
 * @author linSir
 * @version V1.0
 * @Date 2020/1/24 13:46
 */
@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @ResponseBody
    @PostMapping("/put")
    public CommonResults put(@RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResults.failure();
        }
        try {
            return productService.addProduct(product) > 0 ? CommonResults.success(product) : CommonResults.failure();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("添加商品发生异常: {}", e.fillInStackTrace());
            return CommonResults.failure();
        }
    }

    @ResponseBody
    @GetMapping("/get")
    public CommonResults get(@RequestParam("userId") final Integer userId) {
        try {
            List<Product> historyProducts = productService.getHistoryProducts(userId);
            return historyProducts.size() > 0 ? CommonResults.success(historyProducts) : CommonResults.failure();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("查询商品列表发生异常: {}", e.fillInStackTrace());
            return CommonResults.failure();
        }
    }

}
