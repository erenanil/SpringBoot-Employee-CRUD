package com.anileren.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anileren.model.Employee;
import com.anileren.model.UpdateEmployeeRequest;
import com.anileren.repositories.EmployeeRepo;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepo employeeRepo;


    public List<Employee> getAllEmployees(){
        return employeeRepo.getAllEmployees();
    }

    public Employee getEmployeeById(String id){
        return employeeRepo.getEmployeeById(id);
    }

    public List<Employee> getEmployeesWithParam(String name , String surname){
        return employeeRepo.getEmployeesWithParam(name, surname);
    }

    public Employee saveEmployee(Employee newEmployee){
        return employeeRepo.saveEmployee(newEmployee);
    }
    
    public boolean deleteEmployee(String id){
        return employeeRepo.deleteEmployee(id);
    }

    public Employee updateEmployee(String id , UpdateEmployeeRequest request){
        return employeeRepo.updateEmployee(id, request);
    }

}
    
