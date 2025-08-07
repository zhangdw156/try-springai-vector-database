package com.demo.nacos.service.impl;

import com.demo.nacos.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "1.0.0",group = "demo")
public class UserServiceImpl implements UserService {

    @Override
    public String getUserById(String id) {
        return "User " + id + " from Dubbo service";
    }
}
