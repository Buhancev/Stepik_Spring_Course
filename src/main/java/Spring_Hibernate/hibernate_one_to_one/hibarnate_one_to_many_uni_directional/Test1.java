package Spring_Hibernate.hibernate_one_to_one.hibarnate_one_to_many_uni_directional;

import Spring_Hibernate.hibernate_one_to_one.hibarnate_one_to_many_uni_directional.entity.Employee;
import Spring_Hibernate.hibernate_one_to_one.hibarnate_one_to_many_uni_directional.entity.Department;
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
                .addAnnotatedClass(Department.class)
                .buildSessionFactory(); //постройка

        Session session = null;
        try {
            //Обертка вокруг подключения к базе с помощью JDBC, если не будет сессии то не сможем CRUD
             session = factory.getCurrentSession();
            //получаем сессию, делаем операцию и всё (недолго живет, в отличие от SessionFactory)

            //Department department = new Department("HR", 500, 1500);
            //Employee emp1 = new Employee("Sbeta", "Belaya", 800);
            //Employee emp2 = new Employee("Max", "Ruf", 900);

            //department.addEmployeeToDepartment(emp1);
            //department.addEmployeeToDepartment(emp2);

            //открывается транзакция
            session.beginTransaction();
            //********************************

            //session.save(department);
            //Department department = session.get(Department.class, 4);
            //System.out.println(department);
            //System.out.println(department.getEmps());


            //Employee employee = session.get(Employee.class, 6);
            //у работника нет обратной связи, поэтому департамент не удалится как в примере с Bi directional
            //session.delete(employee);

            //Department department = session.get(Department.class, 4);
            //session.delete(department);

            session.getTransaction().commit(); //подтверждаем свои действия

        }

        finally {
            session.close(); //если будет ошибка, то закроем сессию
            factory.close(); //factory может выбрасывать исключение, а нам всегда нужно
            //его закрывать, поэтому можно сделать так(нужно)
        }


    }
}
