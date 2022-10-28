package com.bbuhha;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotitions1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Cat myCat = context.getBean("cat", Cat.class);
        myCat.say();

        context.close();
    }
}
