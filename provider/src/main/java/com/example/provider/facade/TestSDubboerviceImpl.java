package com.example.provider.facade;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.service.TestDubboService;

/**
 * @desc：
 * @author: huangxin
 * @date: 2022.04.13
 */
@DubboService
@Slf4j
public class TestSDubboerviceImpl implements TestDubboService {
    public String test() {
        log.info("请求已经进入TestSDubboerviceImpl的test方法");
        return "dubbo";
    }
}
