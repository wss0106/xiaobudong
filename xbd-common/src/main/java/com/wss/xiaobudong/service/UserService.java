package com.wss.xiaobudong.service;

import com.wss.xiaobudong.model.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weishuaishuai
 * @since 2024-05-23
 */

public interface UserService extends IService<UserDO> {

    UserDO findUserDetail();
}
