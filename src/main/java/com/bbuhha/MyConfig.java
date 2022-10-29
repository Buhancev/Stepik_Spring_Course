package com.bbuhha;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //данный класс является конфигурацией
@ComponentScan("com.bbuhha") //указываем пакет который будет сканирован на наличие бинов и аннотаций
//конфигурация с помощью Java code, а не xml-file
public class MyConfig {
}
