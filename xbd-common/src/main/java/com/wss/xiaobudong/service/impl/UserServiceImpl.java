//package com.wss.xiaobudong.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.wss.xiaobudong.model.UserDO;
//import com.wss.xiaobudong.mapper.UserMapper;
//import com.wss.xiaobudong.service.UserService;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * <p>
// *  服务实现类
// * </p>
// *
// * @author weishuaishuai
// * @since 2024-05-23
// */
//@Service
//public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
//
//    @Autowired
//    private UserMapper userMapper;
//    @Override
//    public UserDO findUserDetail() {
//        UserDO userDO = userMapper.selectOne(new QueryWrapper<UserDO>().eq("id", "3"));
//        return userDO;
//    }
//}
