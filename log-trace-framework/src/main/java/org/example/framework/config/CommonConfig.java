package org.example.framework.config;

import org.example.framework.filter.ControllerFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc：
 * @author: huangxin
 * @date: 2022.04.13
 */
@Configuration
public class CommonConfig {
    @Bean
    public ControllerFilter controllerFilter(){
        return new ControllerFilter();
    }
}
