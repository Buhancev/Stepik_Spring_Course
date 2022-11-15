package com.bbuhha.spring.springboot.spring_data_jpa.service;

import com.bbuhha.spring.springboot.spring_data_jpa.DAO.EmployeeRepository;
import com.bbuhha.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service //отмечает класс, содержащий бизнес логику
//в иерархии компонентов Service является соединительным звеном между Controller и DAO
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional //соблюдается на уровне сервиса, поэтому в методе репозитория нет смысла
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Employee employee = null;

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        }
        else {
            //исключение
        }

        return employee;
    }
    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
