package com.demo.nacos.controller;

import com.demo.nacos.client.ProviderServiceClient;
import com.demo.nacos.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ProviderServiceClient providerServiceClient;

    @DubboReference(version = "1.0.0",group = "demo") // 注入远程服务
    private UserService userService;

    // 消费者对外提供的接口，内部调用服务提供者
    @GetMapping("/call-user/{id}")
    public String callUserService(@PathVariable("id") String id) {
        // 调用服务提供者的接口
        return "调用结果：" + providerServiceClient.getUserById(id);
    }

    @GetMapping("/call-user2/{id}")
    public String callUserService2(@PathVariable("id") String id) {
        return "调用结果：" + userService.getUserById(id);
    }
}
