package com.bbuhha;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] Args) {
        //вот так мы обычно создаем связи
        /*
        Pet pet = new Dog();
        Person person = new Person(pet);
        person.callYoutPet();
        */

        //Теперь пусть за нас это сделает Spring - dependency injection
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);
        Person person = context.getBean("myPerson", Person.class);
        person.callYoutPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());
        /*
        Теперь данный код не нужен, потому что спринг контейнер создаст все бины сам
        и внедрит необходимые зависимости

        Person person = new Person(pet);
        person.callYoutPet();
        */

        //всё равно вручную создаем одъект Person и делаем зависимость через конструктор

        context.close();
    }
}
