package com.bbuhha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personBean")
public class Person {
    //@Autowired //injection через field - unsafe https://habr.com/ru/post/334636/
    //если и выбирать, то либо constuctor injection, либо setter injection (можно смешать)
    //setter - для необязательных (можно делать повторную реинъекцию)
    //конструктор - для обязательных (в кратце)
    //В документации Spring 4.x рекомендуется через конструктор, поскольку
    //он позволяет реализовывать неизменяемые компоненты и гарантировать что требуемые
    //зависимости не null

    //допустим подходят Cat и Dog, то Spring очевидно не может сам решить неоднозначность
    //предотварить выброс данного исключения можно с помощью аннотации @Quilifier
    //она пишется после @Autowired
    private Pet pet;
    // @Value("Buhancev") hardcoded
    @Value("${Person.surname}")
    private String surname;
    //@Value("20") hardcoded поэтому пишем в properties
    @Value("${Person.age}")
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
    Если найдется больше одного bean'a для типа Pet, то @Qualifier

    @Autowired //если в классе имеется 1 конструктор, то можно не писать аннотацию
    //начиная с какой-то там версии Spring сам дописывает это, но это скам
        public Person(@Qualifier("catBean") Pet pet) {
*/
    public Person(Pet pet) {
        this.pet = pet;
    }


    //конверация из файла xml: set -> setPet
    //@Autowired //в принципе вот и всё, при использовании аннотации имя сеттера не важно
    //@Qualifier("catBean")
    public void setPet(Pet pet) {
        System.out.println("Class Person: anyMethodName Pet");
        this.pet = pet;
    }

    public void callYoutPet() {
        System.out.println("Hello!");
        pet.say();
    }
}
