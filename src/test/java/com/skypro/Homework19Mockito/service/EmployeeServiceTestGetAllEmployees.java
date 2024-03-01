package com.skypro.Homework19Mockito.service;

import com.skypro.Homework19Mockito.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceTestGetAllEmployees {
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employeeService = new EmployeeService(); // Создаем реальный экземпляр EmployeeService
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Employee("Denis", "Siliukov", 1, 10_000));
        expectedEmployees.add(new Employee("Daria", "Siliukova", 2, 20_000));

        employeeService.employees.addAll(expectedEmployees);

        List<Employee> actualEmployees = employeeService.getAllEmployees();

        assertEquals(expectedEmployees.size(), actualEmployees.size());
        for (int i = 0; i < expectedEmployees.size(); i++) {
            Employee expectedEmployee = expectedEmployees.get(i);
            Employee actualEmployee = actualEmployees.get(i);
            assertEquals(expectedEmployee.getName(), actualEmployee.getName());
            assertEquals(expectedEmployee.getSurname(), actualEmployee.getSurname());
            assertEquals(expectedEmployee.getDepartment(), actualEmployee.getDepartment());
            assertEquals(expectedEmployee.getSalary(), actualEmployee.getSalary());
        }
    }
}