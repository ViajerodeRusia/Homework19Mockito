package com.skypro.Homework19Mockito.service;

import com.skypro.Homework19Mockito.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class EmployeeServiceTest {
    @Mock
    private List<Employee> employeeList;
    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee("Denis", "Siliukov", 1, 10_000);
        Mockito.when(employeeList.add(employee)).thenReturn(true);
        String result = employeeService.addEmployee("Denis", "Siliukov", 1, 10_000);
        Assertions.assertEquals("success", result);
    }
}