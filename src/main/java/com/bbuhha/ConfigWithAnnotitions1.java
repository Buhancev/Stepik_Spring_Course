package com.bbuhha;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotitions1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Person person = context.getBean("personBean", Person.class);
        person.callYoutPet();


        //Cat myCat = context.getBean("cat", Cat.class);
        //myCat.say();

        System.out.println(person.getAge());
        System.out.println(person.getSurname());

        context.close();
    }
}
