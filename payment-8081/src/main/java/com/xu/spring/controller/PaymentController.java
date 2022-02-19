package com.xu.spring.controller;

import com.xu.spring.entity.CommonResult;
import com.xu.spring.entity.Payment;
import com.xu.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * cloud
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService service;

    @PostMapping(value = "/payment/save")
    public CommonResult save(@RequestBody Payment payment) {
        int result = service.save(payment);
        log.info("插入结果{}", result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        }
        return new CommonResult(444, "插入数据失败");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = service.getPaymentById(id);
        int val = 10 / 2;
        log.info("查询结果{}, 测试热部署={}", payment, val);
        if (null != payment) {
            return new CommonResult(200, "查询数据成功", payment);
        }
        return new CommonResult(444, "查询数据失败");
    }

}
