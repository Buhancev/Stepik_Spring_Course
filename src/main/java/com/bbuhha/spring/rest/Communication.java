package com.bbuhha.spring.rest;

import com.bbuhha.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
//именно с помощью этого класса идет общение КЛИЕНТА с СЕРВЕРОМ
public class Communication {
    @Autowired
    private RestTemplate restTemplate;

    private final String URL  = "http://localhost:8080/spring_cource_rest/api/employees";

    public List<Employee> getAllEmployees() {
        //ответ на http-запрос
        ResponseEntity<List<Employee>> responseEntity =
                //url, тип метода, тело метода, вспомогательный класс для передачи чего то
            restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
            });

        List<Employee> employees = responseEntity.getBody();

        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void saveOrUpdateEmployee(Employee employee) {
        int id = employee.getId();
        if(id == 0) {
            ResponseEntity<String> responseEntity =
                    //какого типа будет тело респонса
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New Employee was added in Database");
            System.out.println(responseEntity.getBody());
        }

        else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID = " + employee + " was updated");
        }
    }

    public void DeleteEmployeeById(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID = " + id + " was deleted");
    }
}
