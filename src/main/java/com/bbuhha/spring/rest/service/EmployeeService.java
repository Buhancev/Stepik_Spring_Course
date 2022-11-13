package com.bbuhha.spring.rest.service;

import com.bbuhha.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveNewEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public void deleteEmployeeById(int id);
}
