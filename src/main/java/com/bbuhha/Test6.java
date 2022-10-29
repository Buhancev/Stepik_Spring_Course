package com.bbuhha;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        //при использовании Jaca code, Spring Container будет представлен классом
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        //можно подумать что cat1 и cat2 будут хранить разные объекты, но т.к scope = singleton, то нет
        //Pet cat1 = context.getBean("catBean", Pet.class);
        //Pet cat2 = context.getBean("catBean", Pet.class);



        Person person = context.getBean("personBean", Person.class);
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        //person.callYoutPet();


        context.close();
    }
}
