package com.xu.spring.controller;

import com.xu.spring.entity.CommonResult;
import com.xu.spring.entity.Payment;
import com.xu.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * cloud
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService service;
    @Value("${server.port}")
    private int server_port;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/save")
    public CommonResult save(@RequestBody Payment payment) {
        int result = service.save(payment);
        log.info("插入结果{}", result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功" + server_port, result);
        }
        return new CommonResult(444, "插入数据失败");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = service.getPaymentById(id);
        int val = 10 / 2;
        log.info("查询结果{}, 测试热部署={}", payment, val);
        if (null != payment) {
            return new CommonResult(200, "查询数据成功" + server_port, payment);
        }
        return new CommonResult(444, "查询数据失败");
    }

    @GetMapping(value = "payment/services")
    public Object getObject() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("********* service {}", element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("+++++++ host={}, port={}", new Object[]{instance.getHost(), instance.getPort()});
        }
        return "";
    }
}
