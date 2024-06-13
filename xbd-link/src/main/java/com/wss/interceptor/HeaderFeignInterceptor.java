package com.wss.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class HeaderFeignInterceptor implements RequestInterceptor {
    private final Environment env;

    @Autowired
    public HeaderFeignInterceptor(Environment env) {
        this.env = env;
    }
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String link_token = env.getProperty("link.token");
        requestTemplate.header("link_token", link_token);
    }
}
