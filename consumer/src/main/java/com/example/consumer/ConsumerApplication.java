package com.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.example.framework.filter.ControllerFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Slf4j
@EnableDubbo
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ConsumerApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.SERVLET);
        springApplication.run(args);
        log.info(" ==============  Consumer ApiApplication start ============== ");
    }

}
