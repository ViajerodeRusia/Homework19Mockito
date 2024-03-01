package com.skypro.Homework19Mockito.service;

import com.skypro.Homework19Mockito.domain.Employee;
import com.skypro.Homework19Mockito.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceTestDuplicate {
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employeeService = new EmployeeService(); // Создаем реальный экземпляр EmployeeService
    }

    @Test
    public void testAddEmployeeDuplicate() {
        String name = "Denis";
        String surname = "Siliukov";
        Integer department = 1;
        Integer salary = 10_000;

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Denis", "Siliukov", 1, 10_000));
        employeeService.employees.addAll(employees);

        String result = employeeService.addEmployee(name, surname, department, salary);

        assertEquals("duplicate", result);
    }
}