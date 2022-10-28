package com.bbuhha;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

    protected void init() {
        System.out.println("Class Dog: init method");
    }
    private void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
