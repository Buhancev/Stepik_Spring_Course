package hibarnate_one_to_many_bi_directional;

import hibarnate_one_to_many_bi_directional.entity.Department;
import hibarnate_one_to_many_bi_directional.entity.Employee;
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

            //Department department = new Department("IT", 300, 500);
            //Employee emp1 = new Employee("Max", "Buhancev", 400);
            //Employee emp2 = new Employee("Danila", "Karavaeva", 500);

            //department.addEmployeeToDepartment(emp1);
            //department.addEmployeeToDepartment(emp2);

            //открывается транзакция
            session.beginTransaction();
            //********************************

            //Department department = session.get(Department.class, 1);
            //System.out.println(department);
            //System.out.println(department.getEmps());
            //********************************

            //Employee employee = session.get(Employee.class, 1);
            //System.out.println(employee);
            //System.out.println(employee.getDepartment());
            //********************************

            //session.save(department);
            //********************************
            //удаление работника потянуло удаление департамента,
            //что в свою очередь удалило ВСЕХ работников в департаменте
            //тк как было cascade = CascadeType.ALL

            //после правок всё стало нормально, убрали REMOVE из каскада
            Employee employee = session.get(Employee.class, 4);
            session.delete(employee);


            session.getTransaction().commit(); //подтверждаем свои действия

        }

        finally {
            session.close(); //если будет ошибка, то закроем сессию
            factory.close(); //factory может выбрасывать исключение, а нам всегда нужно
            //его закрывать, поэтому можно сделать так(нужно)
        }


    }
}
