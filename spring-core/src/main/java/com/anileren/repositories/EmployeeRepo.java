package com.anileren.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anileren.model.Employee;
import com.anileren.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepo {
    
    @Autowired
    List<Employee> employeeList;

    public List<Employee> getAllEmployees(){
        return employeeList;
    }

   public Employee getEmployeeById(String id){
    Employee findEmployee = null;    
    for(Employee employee: employeeList){
            if(id.equals(employee.getId())){
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
   }

   public List<Employee> getEmployeesWithParam(String name , String surname){
    List<Employee> getEmployeeWithParam = new ArrayList<>();
    if(name==null && surname==null){
        return employeeList;
    }
    for (Employee employee : employeeList){
        if(name != null && surname != null){
            if(employee.getName().equalsIgnoreCase(name) && employee.getSurname().equalsIgnoreCase(surname)){
                getEmployeeWithParam.add(employee);
            }
        }
        if(name != null && surname == null){
            if(employee.getName().equalsIgnoreCase(name)){
                getEmployeeWithParam.add(employee);
            }
        }
        if(surname != null && name == null){
            if(employee.getSurname().equalsIgnoreCase(surname)){
                getEmployeeWithParam.add(employee);
            }
        }
    }
    return getEmployeeWithParam;
   }

   public Employee saveEmployee(Employee newEmployee){
    employeeList.add(newEmployee);
    return newEmployee;
   }

   public boolean deleteEmployee(String id){
    Employee deleteEmployee = null;
    for( Employee employee : employeeList ){
        if(id.equals(employee.getId())){
            deleteEmployee = employee;
            break;
        }
    }
    if(deleteEmployee == null){
        return false;
    }
    employeeList.remove(deleteEmployee);
    return true;
   }

   private Employee findEmployeeById(String id){
    Employee findedEmployee = null;
    for (Employee employee : employeeList) {
       if(id.equals(employee.getId())){
            findedEmployee = employee;
            break;
       } 
    }
    return findedEmployee;
   }

   public Employee updateEmployee(String id, UpdateEmployeeRequest request ){

    Employee findedEmployee = findEmployeeById(id);
    if(findedEmployee != null){
        deleteEmployee(id);
        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(id);
        updatedEmployee.setName(request.getName());
        updatedEmployee.setSurname(request.getSurname());
        employeeList.add(updatedEmployee);
        return updatedEmployee;
    }
    return null;
   }






}

