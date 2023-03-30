package com.example.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @desc：
 * @author: huangxin
 * @date: 2022.04.13
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void test() {
        System.out.println(applicationContext.getBean("controllerFilter").toString());
        log.info("请求已经进入TestServiceImpl的test方法");
    }

    @Override
    public void testThreadPool() {
        log.info("请求已经进入TestServiceImpl的test方法");
        taskExecutor.execute(()->{
            log.info("请求已经进入TestServiceImpl的线程池任务");
        });
    }
}
