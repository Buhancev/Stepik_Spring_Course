package com.bbuhha.spring.springboot.spring_cource_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication() //Заменяет Configuration, EnableAutoConfiguration, ComponentScan
public class SpringCourceSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCourceSpringbootApplication.class, args);
        //автоматически создает SpringContainer, поиск bean'ов и их регистрация в контейнере.
        //после этого поднимается TomCat
    }

}
