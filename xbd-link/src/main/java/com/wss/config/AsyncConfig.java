package com.wss.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncConfig implements AsyncConfigurer {

    /**
     * 	•	corePoolSize：核心线程数，即线程池在空闲时保留的最小线程数。
     * 	•	maxPoolSize：最大线程数，即线程池中允许的最大线程数。
     * 	•	queueCapacity：任务队列容量，当所有核心线程都在忙时，新的任务会被放入队列中。
     * 	•	threadNamePrefix：线程名称前缀，用于调试和监控。
     * @return
     */
    @Override
    @Bean(name = "getAsyncExecutor")
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("AsyncExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
