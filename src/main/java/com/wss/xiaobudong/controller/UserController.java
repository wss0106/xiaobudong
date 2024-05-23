package com.wss.xiaobudong.controller;


import com.wss.xiaobudong.model.UserDO;
import com.wss.xiaobudong.service.UserService;
import com.wss.xiaobudong.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weishuaishuai
 * @since 2024-05-23
 */
@RestController
@RequestMapping("/api/user/v1")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/detail")
    public JsonData detail(){
        UserDO user=userService.findUserDetail();
        return JsonData.buildSuccess(user);
    }

}

