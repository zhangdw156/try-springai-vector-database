package com.demo.nacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider")
public interface ProviderServiceClient {

    @GetMapping("/call-user/{id}")
    String getUserById(@PathVariable("id") String id);

}
