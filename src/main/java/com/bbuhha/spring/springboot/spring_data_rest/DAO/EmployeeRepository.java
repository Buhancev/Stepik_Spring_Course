package com.bbuhha.spring.springboot.spring_data_rest.DAO;


import com.bbuhha.spring.springboot.spring_data_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Spring будет использовать best practice API -> Employee -> employees и все http методы будут как
    //в прошлом проекте, потому что это был est practice
}
