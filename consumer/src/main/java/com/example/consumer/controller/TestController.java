package com.example.consumer.controller;

import com.example.consumer.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.service.TestDubboService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @desc：
 * @author: huangxin
 * @date: 2022.04.13
 */
@RestController
@Slf4j
public class TestController {
    @Resource
    private TestService testService;
    @DubboReference
    private TestDubboService testDubboService;

    @RequestMapping("/hello")
    public String hello(){
        log.info("请求已经进入TestController的hello方法");
        testService.test();
        return "hello world";
    }

    @RequestMapping("/dubbo-hello")
    public String dubboHello(){
        log.info("请求已经进入TestController的dubboHello方法");
        testDubboService.test();
        return "hello dubbo";
    }

    @RequestMapping("/threadpool-hello")
    public String testThreadPool(){
        log.info("请求已经进入TestController的testThreadPool方法");
        testService.testThreadPool();
        return "hello thread pool";
    }
}
