package com.bbuhha.spring.springboot.spring_cource_springboot.DAO;

import com.bbuhha.spring.springboot.spring_cource_springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

//    public void saveOrUpdateEmployee (Employee employee);
//
//    public Employee getEmployeeById(int id);
//
//    public void deleteEmployeeById (int id);
}
