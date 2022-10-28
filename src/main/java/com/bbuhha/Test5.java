package com.bbuhha;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.say();

        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.say();

        //не сработал destroy-method? - Не закрыли context!

        /*если у бина scope = prototype, то
        - init method для каждого новосозданного bean'a
        - для этого bean'a destroy-method вызываться не будет
        - программисту нужно самостоятельно писать код для закрытия/освобождения
        ресурсов, которые были использованы в bean'e
         */

        context.close();
    }
}
