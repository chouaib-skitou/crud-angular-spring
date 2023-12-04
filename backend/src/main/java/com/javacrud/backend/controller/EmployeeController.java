package com.javacrud.backend.controller;

import com.javacrud.backend.exception.RessourceNotFoundException;
import com.javacrud.backend.repository.EmployeeRepository;
import com.javacrud.backend.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Employee not found with id: " + id));
        return ResponseEntity.ok(employee);
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
        employeeToUpdate.setPhoneNumber(employee.getPhoneNumber());
        return employeeRepository.save(employeeToUpdate);
    }

    // delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
        Employee employeeToDelete = employeeRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employeeToDelete);
        Map<String, Boolean> response = Map.of("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
