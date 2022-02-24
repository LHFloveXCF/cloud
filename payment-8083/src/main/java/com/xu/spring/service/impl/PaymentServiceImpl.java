package com.xu.spring.service.impl;

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
        // int age = 10 / 0;
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
}
