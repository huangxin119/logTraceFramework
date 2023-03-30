package com.example.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@EnableDubbo
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ProviderApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.SERVLET);
        springApplication.run(args);
        log.info(" ==============  Provider ApiApplication start ============== ");
    }

}
