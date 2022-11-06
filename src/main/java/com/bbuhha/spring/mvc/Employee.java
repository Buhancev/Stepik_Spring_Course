package com.bbuhha.spring.mvc;

import com.bbuhha.spring.mvc.validation.CheckEmail;

import javax.management.remote.JMXServerErrorException;
import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    //Валидация по размеру
    @Size(min = 5, message = "name must be minimum 5 symbols")
    private String name;

    //обязательное поле
    //@NotNull(message = "surname is required field") //Именно не NULL, но это не значит что строка не может быть длинной 0
    //@NotEmpty(message = "surname is required field") //Значение и не NULL, и не пустой String, но можно схитрить и поставить ПРОБЕЛЫ!
    @NotBlank(message = "surname is required field") //Тоже что и NotEmpty, но и проверяет, что поле не состоит из ОДНИХ ПРОБЕЛОВ!
    private String surname;

    @Min(value = 100, message = "must be greater than 99") //min значение для поля
    @Max(value = 10000, message = "must be less than 1001") //max значение для поля
    private int salary;
    private String department;

    private String carBrand;

    private String[] languages;
    private Map<String, String> carBrands;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use pattern XXX-XX-XX") //регулярное выражение
    private String phoneNumber;

    @CheckEmail
    private String email;

    public Employee() {
        carBrands = new HashMap<>();
        carBrands.put("Bmw", "BMW");
        carBrands.put("AUDI", "Audi");
        carBrands.put("Mercedes-Benz", "MB");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
