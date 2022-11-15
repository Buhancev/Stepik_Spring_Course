package com.bbuhha.spring.springboot.spring_data_jpa.DAO;


import com.bbuhha.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
