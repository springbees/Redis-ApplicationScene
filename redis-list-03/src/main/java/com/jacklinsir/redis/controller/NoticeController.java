package com.jacklinsir.redis.controller;

import com.jacklinsir.redis.model.Notice;
import com.jacklinsir.redis.result.CommonResult;
import com.jacklinsir.redis.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/1/21 21:46
 */
@Slf4j
@Controller
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @ResponseBody
    @PostMapping("/put")
    public CommonResult putNotice(@RequestBody @Validated Notice notice, BindingResult result) {
        try {
            if (result.hasErrors()) {
                throw new RuntimeException("参数异常");
            }
            log.info("--平台发送通知给到各位商户：{}", notice);
            return noticeService.pushNotice(notice) == 1 ? CommonResult.success(notice) : CommonResult.filed();
        } catch (Exception e) {
            log.debug("保存通知异常: {}", e.fillInStackTrace());
            return CommonResult.filed();
        }
    }
}
