package com.wss.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wss.model.UserDO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weishuaishuai
 * @since 2024-05-23
 */

public interface UserService {

    UserDO findUserDetail();
}
