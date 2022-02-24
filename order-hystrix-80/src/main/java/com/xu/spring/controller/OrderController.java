package com.xu.spring.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xu.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * cloud
 * 这个演示，主要是为了说明，微服务架构中有一个微服务负载过大，
 * 如果不做处理可能会导致系统中其它服务产生问题
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentService service;

    @GetMapping(value = "/consumer/payment/ok")
    public String ok() {
        return service.ok();
    }

    @GetMapping(value = "/consumer/payment/timeOut")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfo_TimeOut(){
        return service.timeOut();
    }

    //兜底方法
    public String paymentTimeOutFallbackMethod(){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }
}
