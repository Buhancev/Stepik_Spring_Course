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



        Person person1 = context.getBean("personBean", Person.class);
        Person person2 = context.getBean("personBean", Person.class);

        //person.callYoutPet();


        context.close();
    }
}
