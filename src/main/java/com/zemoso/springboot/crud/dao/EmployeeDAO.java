package com.zemoso.springboot.crud.dao;

import com.zemoso.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
    Employee findById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployee(int id);

}
