package com.wss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wss.context.DataSourceContextHolder;
import com.wss.mapper.UserMapper;
import com.wss.model.UserDO;
import com.wss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weishuaishuai
 * @since 2024-05-23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDO findUserDetail() {
        DataSourceContextHolder.setDataSourceKey("dataSource1");
        try {
            UserDO userDO = userMapper.selectOne(String.valueOf(111));
             return userDO;
        }finally{
            DataSourceContextHolder.clearDataSourceKey();
        }
    }
}
