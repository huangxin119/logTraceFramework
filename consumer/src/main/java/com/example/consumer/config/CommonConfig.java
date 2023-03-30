package com.example.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @desc：
 * @author: huangxin
 * @date: 2022.04.14
 */
@Configuration
public class CommonConfig {
    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1);
        taskExecutor.setMaxPoolSize(2);
        taskExecutor.setQueueCapacity(2);
        taskExecutor.setKeepAliveSeconds(1000);
        return taskExecutor;
    }
}
