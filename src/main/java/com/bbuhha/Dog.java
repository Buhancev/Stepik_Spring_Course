package com.bbuhha;

public class Dog implements Pet {
    private String name;

    public Dog() {
        System.out.println("Dog bean created");
    }

    public String getName() {
        return name;
    }
    //
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
}
