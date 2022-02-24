package com.xu.spring.service;

import org.springframework.stereotype.Service;

/**
 * cloud
 */
@Service
public class PaymentService {
    public String ok() {
        return "当前线程：" + Thread.currentThread().getName() + "成功请求！";
    }

    public String timeOut() {
        return "当前线程：" + Thread.currentThread().getName() + "超时了！";
    }
}
