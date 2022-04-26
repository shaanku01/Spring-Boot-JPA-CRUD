package com.zemoso.springboot.crud.dao;

import com.zemoso.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    @Autowired
    EntityManager entityManager;
    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class,id);

        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee employee1 = entityManager.merge(employee);
        employee.setId(employee1.getId());
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();

    }
}
