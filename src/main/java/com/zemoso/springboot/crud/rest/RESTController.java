package com.zemoso.springboot.crud.rest;

import com.zemoso.springboot.crud.dao.EmployeeDAO;
import com.zemoso.springboot.crud.entity.Employee;
import com.zemoso.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
   EmployeeService employeeService;




    @GetMapping("/employees")
    public List<Employee> findAll(){
        List<Employee> employees = employeeService.findAll();
        return employees;

    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw  new RuntimeException("Not found");
        }
        return  employee;

    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody  Employee employee){
        employee.setId(0);

        employeeService.saveEmployee(employee);

        return employee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee( @RequestBody Employee employee){

        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmployee(@PathVariable int employeeId){
        Employee deletedEmp = employeeService.findById(employeeId);
        if(deletedEmp == null)
            throw new RuntimeException("THe employee does not exist");
        employeeService.deleteEmployee(employeeId);
        return deletedEmp;

    }


}
