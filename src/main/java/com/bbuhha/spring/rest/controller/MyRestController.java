package com.bbuhha.spring.rest.controller;

import com.bbuhha.spring.rest.entity.Employee;
import com.bbuhha.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //контроллер, который управляет REST запросами
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    //@GetMapping("/employees")
}
