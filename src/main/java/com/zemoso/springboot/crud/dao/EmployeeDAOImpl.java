package com.zemoso.springboot.crud.dao;

import com.zemoso.springboot.crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override

    public List<Employee> findAll() {

        //Get the current hibernate Session::
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query

        Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
        //exec the query

        List<Employee> employees = query.getResultList();

        //return the result.
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);


        //exec the query

        Employee employee = currentSession.get(Employee.class,id);

        //return the result.
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);


    }

    @Override
    public void deleteEmployee(int id) {

        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();

    }
}
