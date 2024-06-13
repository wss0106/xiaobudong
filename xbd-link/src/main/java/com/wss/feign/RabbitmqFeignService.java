package com.wss.feign;

import com.wss.interceptor.HeaderFeignInterceptor;
import com.wss.xiaobudong.utils.JsonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "rabbitmqFeignService",
        configuration = HeaderFeignInterceptor.class,
        url = "http://localhost:8085")
public interface RabbitmqFeignService {
    @GetMapping("/api/mqmsg/v1/add")
    JsonData msgAdd();
}
