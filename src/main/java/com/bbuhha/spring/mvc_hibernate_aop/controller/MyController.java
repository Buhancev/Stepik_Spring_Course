package com.bbuhha.spring.mvc_hibernate_aop.controller;

import com.bbuhha.spring.mvc_hibernate_aop.DAO.EmployeeDAO;
import com.bbuhha.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeDAO employeeDAO;


    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeDAO.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);

        return "allEmployees";
    }
}
