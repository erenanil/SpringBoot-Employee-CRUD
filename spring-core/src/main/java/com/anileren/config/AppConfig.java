package com.anileren.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anileren.model.Employee;

@Configuration
public class AppConfig {
    
    @Bean
    public List<Employee> getAllEmployees(){
        List<Employee> allEmployee = new ArrayList<>();
        allEmployee.add(new Employee("1","Anil","Eren"));
        allEmployee.add(new Employee("2","Tuna","Agis"));
        allEmployee.add(new Employee("3","Enes","Altın"));
        allEmployee.add(new Employee("4","Anil","Bozkurt"));
        allEmployee.add(new Employee("5","Betül","EREN"));
        allEmployee.add(new Employee("6","Damla","Kurt"));
        return allEmployee;
    }

}
