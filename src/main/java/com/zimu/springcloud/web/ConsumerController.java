package com.zimu.springcloud.web;

import com.zimu.entities.CommonResult;
import com.zimu.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
//    private String PAYMENT_URL="HTTP://localhost:8001"; url不能写死，写服务提供者的服务名
    private String PAYMENT_URL="HTTP://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @PostMapping("create")
    public CommonResult<Payment> creatPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
}
