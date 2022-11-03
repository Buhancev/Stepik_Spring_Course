package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
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

//            Employee employee = new Employee("Maxim", "Buhancev", "CFT", 100);
//            Detail detail = new Detail("Nsk", "1234567890", "maxim@gmail.com");
//
//            employee.setEmpDetail(detail);
//
//            //открывается транзакция
//            session.beginTransaction();
//
//            session.persist(employee);
//
//            session.getTransaction().commit(); //подтверждаем свои действия




            //открывается транзакция
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit(); //подтверждаем свои действия

        }

        finally {
            session.close(); //если будет ошибка, то закроем сессию
            factory.close(); //factory может выбрасывать исключение, а нам всегда нужно
            //его закрывать, поэтому можно сделать так(нужно)
        }


    }
}
