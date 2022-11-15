package com.bbuhha.spring.springboot.spring_data_jpa.service;

import com.bbuhha.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveOrUpdateEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public void deleteEmployeeById(int id);

    public List<Employee> findAllByName(String name);
}
