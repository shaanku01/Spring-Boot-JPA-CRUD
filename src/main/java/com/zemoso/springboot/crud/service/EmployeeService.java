package com.zemoso.springboot.crud.service;

import com.zemoso.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    Employee findById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
