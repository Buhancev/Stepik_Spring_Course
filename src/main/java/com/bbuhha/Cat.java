package com.bbuhha;

public class Cat implements Pet{
    public Cat() {
        System.out.println("Cat bean created");
    }
    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
