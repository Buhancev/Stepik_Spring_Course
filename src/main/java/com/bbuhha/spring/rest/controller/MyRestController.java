package com.bbuhha.spring.rest.controller;

import com.bbuhha.spring.rest.entity.Employee;
import com.bbuhha.spring.rest.exceptionHandling.EmployeeIncorrectData;
import com.bbuhha.spring.rest.exceptionHandling.NoSuchEmployeeException;
import com.bbuhha.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //контроллер, который управляет REST запросами
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
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

    @ExceptionHandler //метод, ответственный за обработку исключений
    //ResponseEntity - обертка HTTP response
    public ResponseEntity<EmployeeIncorrectData> handleExceptionNotFound(
            //В случае выбрасывания NoSuchEmployeeException мы должны добавить в тело Response добавить объект EmployeeIncorrectData
            //грубо говоря, на какой exception реагирует данный метод
            NoSuchEmployeeException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        //передаем сам объект, и статус код нашего HTTP-response
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler //метод, ответственный за обработку исключений
    //ResponseEntity - обертка HTTP response
    public ResponseEntity<EmployeeIncorrectData> handleExceptionAny(
            //В случае выбрасывания любой ошибка мы должны добавить в тело Response добавить объект EmployeeIncorrectData
            //грубо говоря, на какой exception реагирует данный метод
            Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        //передаем сам объект, и статус код нашего HTTP-response
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
