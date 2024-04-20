package com.employee.crud.controller;

import com.employee.crud.entity.Employee;
import com.employee.crud.service.EmployeeService;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping("/api/employee")
    public Employee saveEmployee(@RequestBody Employee emp) {
        return empService.saveEmployee(emp);
    }

    @GetMapping("/api/employee")
    public List<Employee> getAllEmployee() {
        return empService.fetchAllEmployees();
    }

    @GetMapping("/api/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return empService.getEmployeeById(id);
    }

    @PutMapping("/api/employee/{id}")
    public Employee upEmployee(@PathVariable("id") Long id, @RequestBody Employee emp) {
        return empService.updateEmployeeById(id, emp);
    }

    @DeleteMapping("/api/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return empService.deleteEmployeeById(id);
    }
}

