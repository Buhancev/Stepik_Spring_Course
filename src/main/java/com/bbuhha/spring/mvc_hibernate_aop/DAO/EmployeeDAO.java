package com.bbuhha.spring.mvc_hibernate_aop.DAO;

import com.bbuhha.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveNewEmployee (Employee employee);

    public Employee getEmployeeById(int id);
}
