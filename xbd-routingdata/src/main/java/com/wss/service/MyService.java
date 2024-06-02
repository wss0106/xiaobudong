//package com.wss.service;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.wss.context.DataSourceContextHolder;
//import com.wss.mapper.UserMapper;
//import com.wss.model.UserDO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyService {
//
//    @Autowired
//    private UserMapper userMapper;
//
////    public void someMethod() {
////        try {
////            DataSourceContextHolder.setDataSourceKey("dataSource2");
////            // 执行数据库操作
////        } finally {
////            DataSourceContextHolder.clearDataSourceKey();
////        }
////    }
//
//    public Integer getCountUser() {
//        DataSourceContextHolder.setDataSourceKey("mysql");
//        try {
//            return userMapper.selectCount(new QueryWrapper<UserDO>());
//        } finally {
//            DataSourceContextHolder.clearDataSourceKey();
//        }
//    }
//}
