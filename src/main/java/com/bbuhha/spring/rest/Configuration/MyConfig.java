package com.bbuhha.spring.rest.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.bbuhha.spring.rest")
public class MyConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(); //для осуществления http-request
    }
}
