package com.wss.xiaobudong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wss.xiaobudong.mapper")
public class XiaobudongApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaobudongApplication.class, args);
    }

}
