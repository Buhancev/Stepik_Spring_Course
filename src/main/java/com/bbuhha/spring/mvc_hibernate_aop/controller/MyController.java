package com.bbuhha.spring.mvc_hibernate_aop.controller;

import com.bbuhha.spring.mvc_hibernate_aop.entity.Employee;
import com.bbuhha.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);

        return "allEmployees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employeeInfo";
    }

    @RequestMapping("/saveEmployee")
    public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveNewEmployee(employee);

        return "redirect:/"; //перенаправляем на /
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);

        return "employeeInfo";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {

        employeeService.deleteEmployeeById(id);

        return "redirect:/"; //перенаправляем на /
    }
}
