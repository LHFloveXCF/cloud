package com.xu.spring.service.impl;

import com.xu.spring.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * cloud
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String ok() {
        return "当前线程：" + Thread.currentThread().getName() + "成功请求！";
    }

    @Override
    public String timeOut() {
        return "当前线程：" + Thread.currentThread().getName() + "超时了！";
    }
}
