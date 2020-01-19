package com.jacklinsir.redis.controller;

import com.jacklinsir.redis.model.Item;
import com.jacklinsir.redis.result.CommonResult;
import com.jacklinsir.redis.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/18 23:11
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;


    /**
     * 保存商品
     *
     * @param item
     * @param result
     * @return
     */
    @PostMapping(value = "/put")
    public CommonResult put(@RequestBody @Validated Item item, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.fail();
        }
        return itemService.add(item) == 1 ? CommonResult.success("保存成功") : CommonResult.fail();
    }

    /**
     * 获取商品
     *
     * @param id
     * @return
     */
    @GetMapping("/get")
    public CommonResult get(@RequestParam("id") Integer id) {
        Item item = itemService.getByItemId(id);
        return item != null ? CommonResult.success(item) : CommonResult.fail();
    }
}
