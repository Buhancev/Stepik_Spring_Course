package Spring_Hibernate.hibernate_one_to_one.hibernate;

import Spring_Hibernate.hibernate_one_to_one.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5 {
    public static void main(String[] args) {
        //должны создать сессию, чтобы иметь доступ к БД
        //для начала нужно создать SessionFactory
        //достаточно создать 1 раз, можно переиспользовать
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//SessionFactory узнает как создать сессию
                .addAnnotatedClass(Employee.class) //Entity класс
                .buildSessionFactory(); //постройка

        try {
            //Обертка вокруг подключения к базе с помощью JDBC, если не будет сессии то не сможем CRUD
            Session session = factory.getCurrentSession();
            //получаем сессию, делаем операцию и всё (недолго живет, в отличие от SessionFactory)

            //открывается транзакция
            session.beginTransaction();

            //Employee emp = session.get(Employee.class, 1);
            //всё
            //session.delete(emp);

            session.createQuery("delete Employee " +
                    "where name = 'Elena'").executeUpdate();

            session.getTransaction().commit();


        }

        finally {
            factory.close(); //factory может выбрасывать исключение, а нам всегда нужно
            //его закрывать, поэтому можно сделать так(нужно)
        }


    }
}
