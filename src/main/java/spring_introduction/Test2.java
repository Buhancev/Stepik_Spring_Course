package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] Args) {

        /*ApplicationContext представляет собой Spring Container. Поэтому для получения
          бина из Spring Container нужно создать ApplicationContext*/
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //Получаем объект Dog из него
        //Первый аргумент - id bean, который хотим получить
        //Любая Dog - Pet, поэтому второй аргумент Pet.class (Dog implement Pet)
                                 //id bean      type bean
        Pet pet = context.getBean("myPet", Pet.class);
        /*Почему же написали не Dog, а Pet? Потому что если поменять конфиг. файл, то
        придется менять код и тут, а это глупо в том смысле, что конфиг. файл и нужен
        чтобы менять только в нём что-то, а основной код не трогать!
         */

        //Ура! Создали первое Spring application
        pet.say();
        //закрываем Spring Container
        context.close();


        /* Пока у нас всего 1 bean и нет injection, не понятно зачем такое муторное
         создание. Но даже сейчас понятно, что при замене Dog на Сat нам не придется
         перекомплиировавать код, поскольку код выше никак не будет изменяться */
    }
}
