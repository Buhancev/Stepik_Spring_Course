package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
        //можем читать информацию не только из одного конфиг файла, а сразу из нескольких
        //для этого нужно через запятую перечислить нужные - "name1", "name2"
                new ClassPathXmlApplicationContext("applicationContext2.xml");


        Dog myDog = context.getBean("myPet", Dog.class);
        //myDog.setName("Belka");
        Dog yourDog = context.getBean("myPet", Dog.class);
        //yourDog.setName("Strelka");

        //System.out.println(myDog.getName());
        // System.out.println(yourDog.getName());

        if(myDog.equals(yourDog))
            System.out.println("Переменные ссылаются на один и тот же объект");
        else
            System.out.println("Переменные НЕ ссылаются на один и тот же объект");

        System.out.println("адрес объекта myDog" + myDog);
        System.out.println("адрес объекта yourDog" + yourDog);

        context.close();
    }
}
