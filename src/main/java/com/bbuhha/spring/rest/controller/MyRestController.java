package com.bbuhha.spring.rest.controller;

import com.bbuhha.spring.rest.entity.Employee;
import com.bbuhha.spring.rest.exceptionHandling.NoSuchEmployeeException;
import com.bbuhha.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //контроллер, который управляет REST запросами
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees; //отправляет List<Employee>, который Spring преобразует в json
    }

    @GetMapping("/employees/{id}") //Получаем id из тела метода GET http-request
    //аннотация PathVariable используется для получения значения переменной из АДРЕСА запроса
    public Employee showEmployeeById(@PathVariable int id) {

        Employee employee = employeeService.getEmployeeById(id);

        //если работника нет, то будет null -> пустой json
        //если вместо номера id вписать строку(например), то будет 400 - bad request, в котором нет ничего информативного

        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }

        return employee; //отправляет Employee, который Spring преобразует в json
    }

    @PostMapping("/employees")
                                            //в body Http-request придет работник
    public Employee addNewEmployeeAndReturnHim(@RequestBody Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        //возвращаем этого же работника, но уже добавленного в БД, который имеет id
        return employee;
    }

    @PutMapping("/employees")
    //в body Http-request придет работник, который из json конвертируется в java-object (за это отвечает jackson)
    public Employee updateEmployeeAndReturnHim(@RequestBody Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeAndReturnHim(@PathVariable int id) {
        //проверяем есть ли вообще такой работник
        Employee employee = employeeService.getEmployeeById(id);

        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database. Delete could not be complete");
        }

        employeeService.deleteEmployeeById(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
