package com.wss.xiaobudong.config;

import com.wss.xiaobudong.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        添加拦截路径
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("")
//                不拦截
                .excludePathPatterns("");
    }
}
