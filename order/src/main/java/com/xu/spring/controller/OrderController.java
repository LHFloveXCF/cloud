package com.xu.spring.controller;

import com.xu.spring.entity.CommonResult;
import com.xu.spring.entity.Payment;
import com.xu.spring.mylb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * cloud
 */
@RestController
@Slf4j
public class OrderController {

    // private static final String PAYMENT_URL = "http://localhost:8081";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate template;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalance loadBalance;

    @GetMapping(value = "/consumer/payment/save")
    public CommonResult save(Payment payment) {
        log.info("hello world");
        return template.postForObject(PAYMENT_URL + "/payment/save/", payment, CommonResult.class);
        // return template.getForObject(PAYMENT_URL + "save/", CommonResult.class, payment);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult save(@PathVariable("id") Long id) {
        return template.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/myLB")
    public String myLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalance.getInstance(instances);
        if (null == instance) {
            return "no service up!";
        }
        URI uri = instance.getUri();
        log.info("***************{}", uri);
        return template.getForObject(uri + "/payment/myLB", String.class);
    }
}
