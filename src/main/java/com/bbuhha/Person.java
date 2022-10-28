package com.bbuhha;

public class Person {
    private Pet pet;
    private String surname;
    private int age;

    public Person() {
        System.out.println("Person bean created");
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public String getSurname() {
        System.out.println("Class Person: get surname");
        return surname;
    }

    public int getAge() {
        System.out.println("Class Person: get age");
        return age;
    }

    public Person(Pet pet) {
        System.out.println("Person bean created");
        this.pet = pet;
    }


    //конверация из файла xml: set -> setPet
    public void setPet(Pet pet) {
        System.out.println("Class Person: set Pet");
        this.pet = pet;
    }

    public void callYoutPet() {
        System.out.println("Hello!");
        pet.say();
    }
}
