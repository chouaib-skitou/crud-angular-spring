package com.javacrud.backend.controller;

import com.javacrud.backend.repository.EmployeeRepository;
import com.javacrud.backend.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;


    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // get employee by id
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeRepository.findById(id).orElse(null); // Handle the case where the employee is not found
    }

    // create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // update employee
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElse(null);
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmailId(employee.getEmailId());
        return employeeRepository.save(employeeToUpdate);
    }

    // delete employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted with id: " + id;
    }


}
