package com.bbuhha.spring.mvc_hibernate_aop.service;

import com.bbuhha.spring.mvc_hibernate_aop.DAO.EmployeeDAO;
import com.bbuhha.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //отмечает класс, содержащий бизнес логику
//в иерархии компонентов Service является соединительным звеном между Controller и DAO
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional //соблюдается на уровне сервиса, поэтому в методе репозитория нет смысла
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveNewEmployee(Employee employee) {
        employeeDAO.saveNewEmployee(employee);
    }
}
