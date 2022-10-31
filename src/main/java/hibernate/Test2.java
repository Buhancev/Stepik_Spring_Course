package hibernate;

import hibernate.entity.Employee;
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
                .buildSessionFactory(); //постройка

        try {
            //Обертка вокруг подключения к базе с помощью JDBC, если не будет сессии то не сможем CRUD
            Session session = factory.getCurrentSession();
            //получаем сессию, делаем операцию и всё (недолго живет, в отличие от SessionFactory)

            Employee emp = new Employee("Oleg", "Sidorov",
                    "HR", 0);

            //открывается транзакция
            session.beginTransaction();
            session.save(emp); //insert
            //session.getTransaction().commit(); //подтверждаем свои действия

            int myId = emp.getId();
            //session = factory.getCurrentSession();
            //session.beginTransaction();
                                    //тип получаемого объекта, id
            Employee employee = session.get(Employee.class, myId);
            //закрыли транзакцию
            session.getTransaction().commit();

            System.out.println(employee);
        }

        finally {
            factory.close(); //factory может выбрасывать исключение, а нам всегда нужно
            //его закрывать, поэтому можно сделать так(нужно)
        }


    }
}
