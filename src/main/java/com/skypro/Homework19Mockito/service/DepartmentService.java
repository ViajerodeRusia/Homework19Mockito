package com.skypro.Homework19Mockito.service;

import com.skypro.Homework19Mockito.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee getEmployeeWithMinSalaryDep(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    public Employee getEmployeeWithMaxSalaryDep(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    public Integer getCostsAllEmployees() {
        Integer sum = employeeService.getAllEmployees().stream()
                .mapToInt(Employee::getSalary)
                .sum();
        return sum;
    }

    public Integer getCostsAllEmployeesDep(Integer department) {
        Integer sum = employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToInt(Employee::getSalary)
                .sum();
        return sum;
    }

    public Employee getEmployeeWithMinSalary() {
        return employeeService.getAllEmployees().stream()
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }

    public Employee getEmployeeWithMaxSalary() {
        return employeeService.getAllEmployees().stream()
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    public List<Employee> getAllEmployeesOfDepartment(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
}
