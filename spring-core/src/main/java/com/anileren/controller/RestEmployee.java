package com.anileren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anileren.model.Employee;
import com.anileren.model.UpdateEmployeeRequest;
import com.anileren.services.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;










@RestController
@RequestMapping(path = "/rest/api/employee")
public class RestEmployee {
    
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id",required = true) String id) {
        return employeeService.getEmployeeById(id);
    }
  
    @GetMapping("/with-params")
    public List<Employee> getEmployeesWithParam(@RequestParam(name = "name",required = false)String name , @RequestParam(name = "surname",required = false) String surname) {
        return employeeService.getEmployeesWithParam(name, surname);
    }
    
    @PostMapping("/save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee) {
        return employeeService.saveEmployee(newEmployee);
    }
    
    @DeleteMapping("/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id")String id){
        return employeeService.deleteEmployee(id);
    }
   
    @PutMapping("update-employee/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody UpdateEmployeeRequest request) {
       return employeeService.updateEmployee(id, request);
    }
}
