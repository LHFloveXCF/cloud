package com.xu.spring.service.impl;

import cn.hutool.Hutool;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xu.spring.service.PaymentService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * cloud
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String ok() {
        return "当前线程：" + Thread.currentThread().getName() + "成功请求！";
    }

    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000") // 超时设置
    })
    @Override
    public String timeOut() {
        int age = 10 / 0;
        try {
            // TimeUnit.MILLISECONDS.sleep(5000L);
            // Thread.sleep(5000L);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "当前线程：" + Thread.currentThread().getName() + "超时了！";
    }

    /**
     * 超时、异常、导致的服务降级业务处理
     * @return
     */
    public String timeOutHandler() {
        return "当前线程：" + Thread.currentThread().getName() + "系统繁忙，请稍后再试！";
    }

    // ***********************服务熔断***********************
    @Override
    @HystrixCommand(fallbackMethod = "circuitHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String circuit(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能小于0");
        }
        return "right " + IdUtil.randomUUID();
    }

    public String circuitHandler(Integer id){
        return "wrong " + IdUtil.randomUUID();
    }
}
