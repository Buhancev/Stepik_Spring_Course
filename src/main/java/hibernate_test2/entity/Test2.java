package hibernate_test2.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        //должны создать сессию, чтобы иметь доступ к БД
        //для начала нужно создать SessionFactory
        //достаточно создать 1 раз, можно переиспользовать
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//SessionFactory узнает как создать сессию
                .addAnnotatedClass(Employee.class) //Entity класс
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory(); //постройка

        Session session = null;
        try {
            //Обертка вокруг подключения к базе с помощью JDBC, если не будет сессии то не сможем CRUD
             session = factory.getCurrentSession();
            //получаем сессию, делаем операцию и всё (недолго живет, в отличие от SessionFactory)

//            Employee employee = new Employee("Sidor", "Ivanov", "HR", 80);
//            Detail detail = new Detail("NY", "453454345", "NYSIDR@mail.com");
//
//            employee.setEmpDetail(detail); //если тут сохранить, то details_id БУДЕТ ссылаться
//            detail.setDetEmployee(employee);
//
//
//            //открывается транзакция
//            session.beginTransaction();
//
//            session.persist(detail); //если сделать так, то Employee не ссылкается на detail
//
//            System.out.println(employee.getEmpDetail());
//
//            session.getTransaction().commit(); //подтверждаем свои действия



            //открывается транзакция
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 4);
            session.delete(detail);

            session.getTransaction().commit(); //подтверждаем свои действия

        }

        finally {
            session.close(); //если будет ошибка, то закроем сессию
            factory.close(); //factory может выбрасывать исключение, а нам всегда нужно
            //его закрывать, поэтому можно сделать так(нужно)
        }


    }
}
