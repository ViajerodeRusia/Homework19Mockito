package com.skypro.Homework19Mockito.service;

import com.skypro.Homework19Mockito.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    final List<Employee> employees = new ArrayList<>();
    public String addEmployee(String name, String surname, Integer department, Integer salary) {
        if(employees.stream().noneMatch(e -> e.getName().equals(name) && e.getSurname().equals(surname))) {
            employees.add(new Employee(name, surname, department, salary));
            return "success";
        }
        return "duplicate";
    }
    public List<Employee> getAllEmployees() {
        return employees;
    }
}

