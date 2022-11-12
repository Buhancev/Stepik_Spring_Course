package com.bbuhha.spring.mvc_hibernate_aop.DAO;

import com.bbuhha.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//Это тоже @Component, нужна для DAO, при поиске компонентов, Spring также
//будет регистрировать все DAO с аннотацией @Repository в Spring Container'e
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    //Так как мы создали bean в нашем xml файле, то Spring сам найдет,
    //достанет из Spring Container'a и свяжет SessionFactory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //@Transactional перенесли в сервис
    public List<Employee> getAllEmployees() {
        //транзакцию можно доверить спрингу, чтобы не открывать и не закрывать
        //самостоятельно, для этого нужна аннотация @Transactional
        Session session = sessionFactory.getCurrentSession();

//        List<Employee> allEmployees = session.createQuery(
//                "from Employee", Employee.class)
//                .getResultList();

        Query<Employee> query = session.createQuery(
                "from Employee", Employee.class);

        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveNewEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        //тк по дефолту Employee имеет id = 0 (если это новый работник, которого мы добавляем)
        //if(employee.getId() == 0 ) session.save(employee);
        //а если изменяем существующего, то id не пустой (не равен 0)
        //else{длинная логика обновления} НО! В Hibernate есть метод который содержит И SAVE, И UPDATE!

        //он работает по такой же логике, которая описана выше!
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();

        //более простой вариант
        //Employee employee = getEmployeeById(id);
        //session.delete(employee);


        /*
        а можно создать запрос на удаление, он может быть СЛОЖНЫМ (то есть обычного удаления по id, которое даёт метод delete
        может быть недостаточно!
         */
        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeId"); //запрос с параметром! Имя параметра - employeeId

        query.setParameter("employeeId", id); //имя параметра, значение параметра
        query.executeUpdate(); //update + delete
    }
}
