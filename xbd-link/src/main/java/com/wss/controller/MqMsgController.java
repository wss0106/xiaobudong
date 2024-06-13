package com.wss.controller;

import com.wss.feign.RabbitmqFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/link/v1")
public class MqMsgController {
    @Autowired
    private RabbitmqFeignService rabbitmqFeignService;
    @GetMapping("/addmsg")
    public void addmqMsg(){
        rabbitmqFeignService.msgAdd();
    }
}
