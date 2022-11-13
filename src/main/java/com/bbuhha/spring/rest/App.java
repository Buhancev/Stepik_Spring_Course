package com.bbuhha.spring.rest;

import com.bbuhha.spring.rest.Configuration.MyConfig;
import com.bbuhha.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee empById = communication.getEmployeeById(11);
//        System.out.println(empById);

        Employee emp = new Employee("Sveta", "Belaya", "IT", 1200);

        emp.setId(12);

        communication.DeleteEmployeeById(12);
    }
}
