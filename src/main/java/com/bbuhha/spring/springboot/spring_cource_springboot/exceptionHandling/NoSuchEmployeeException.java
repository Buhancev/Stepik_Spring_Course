package com.bbuhha.spring.springboot.spring_cource_springboot.exceptionHandling;

public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
