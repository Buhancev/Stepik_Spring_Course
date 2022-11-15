package com.bbuhha.spring.springboot.spring_data_jpa.DAO;


import com.bbuhha.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //если методов не хватает, то можно спокойно самому добавить
    //можно создать метод с ОПРЕДЕЛЕННЫМ ИМЕНЕМ, КОТОРОЕ СЛЕДУЕТ ПРАВИЛАМ
    //если правила соблюдены, то можно даже не реализовывать метод!
    public List<Employee> findAllByName(String name); //не реализовываем благодаря стандартизации методов!
}
