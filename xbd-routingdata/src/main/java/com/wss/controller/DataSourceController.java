package com.wss.controller;

import com.wss.model.UserDO;

import com.wss.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/user/v1")
public class DataSourceController {
    @Autowired
    private UserService userService;

    @GetMapping("/detail")
    public Object detail(){
        UserDO userDetail = userService.findUserDetail();
         log.info("本次查询获取用户总数是:"+userDetail.toString());
         return userDetail;
    }
}
