package com.bbuhha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    @Autowired //injection через field - unsafe https://habr.com/ru/post/334636/
    //если и выбирать, то либо constuctor injection, либо setter injection
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

    /*
    Как Spring связывает классы Person и Cat? Он ищет классы, помеченные @Component,
    затем т.к Person & Cat - singleton создает их, затем видит на конструкторе Person
    @Autowired и пытается ввести зависимость. Каким образом? - Он ищет подходящие bean'ы
    по типу Pet. Он находит Cat, т.к класс Cat implement Pet. Успешно внедряет зависимость.
    Если ни один bean не будет соответстовать типа Pet, то не комплируется (ген. искл).
    Если найдется больше одного bean'a для типа Pet, то ... ?

    @Autowired //если в классе имеется 1 конструктор, то можно не писать аннотацию
    //начиная с какой-то там версии Spring сам дописывает это, но это скам
    public Person(Pet pet) {
        System.out.println("Person bean created");
        this.pet = pet;
    }
    */

    //конверация из файла xml: set -> setPet
    //@Autowired //в принципе вот и всё, при использовании аннотации имя сеттера не важно
    public void setPet(Pet pet) {
        System.out.println("Class Person: anyMethodName Pet");
        this.pet = pet;
    }

    public void callYoutPet() {
        System.out.println("Hello!");
        pet.say();
    }
}
