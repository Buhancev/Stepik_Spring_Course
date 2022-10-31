package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3 {
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
            //получим всех работников и выведем на экран
//                                                            // не имя таблицы, а имя Класса
//            List<Employee> employeeList = session.createQuery("from Employee")
//                    .getResultList();

            //по имени получаем
            List<Employee> employeeList = session.createQuery("from Employee "
                        //название не СТОЛБЦА в БД, а ПОЛЯ в Employee
                    + "where name = 'Max' OR salary > 100")
                    .getResultList();

            session.getTransaction().commit();

            for(Employee e : employeeList)
                System.out.println(e);
        }

        finally {
            factory.close(); //factory может выбрасывать исключение, а нам всегда нужно
            //его закрывать, поэтому можно сделать так(нужно)
        }


    }
}
