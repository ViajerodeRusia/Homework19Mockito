package com.skypro.Homework19Mockito.service;
import com.skypro.Homework19Mockito.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        List<Employee> employeeList = Arrays.asList(
                new Employee( "Denis", "Siliukov", 1, 20_000),
                new Employee( "Dasha", "Siliukova", 1, 30_000),
                new Employee( "Svetlana", "Siliukova", 2, 40_000),
                new Employee( "Ekaterina", "Siliukova", 2, 10_000)
        );

        //Поведение мока
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);
    }

    @Test
    void getEmployeeWithMinSalaryDep() {
        var min = departmentService.getEmployeeWithMinSalaryDep(1);
        Assertions.assertEquals(20_000, min.getSalary());
    }

    @Test
    void getEmployeeWithMaxSalaryDep() {
        var max = departmentService.getEmployeeWithMaxSalaryDep(1);
        Assertions.assertEquals(30_000, max.getSalary());
    }

    @Test
    void getCostsAllEmployees() {
        Integer costs = departmentService.getCostsAllEmployees();
        Assertions.assertEquals(100_000, costs);
    }

    @Test
    void getCostsAllEmployeesDep() {
        var departmentCosts = departmentService.getCostsAllEmployeesDep(1);
        Assertions.assertEquals(50_000, departmentCosts);
    }

    @Test
    void getEmployeeWithMinSalary() {
        var min = departmentService.getEmployeeWithMinSalary();
        Assertions.assertEquals(10_000, min.getSalary());
    }

    @Test
    void getEmployeeWithMaxSalary() {
        var max = departmentService.getEmployeeWithMaxSalary();
        Assertions.assertEquals(40_000, max.getSalary());
    }

    @Test
    void getAllEmployeesOfDepartment() {
        List<Employee> result = departmentService.getAllEmployeesOfDepartment(1);
        Assertions.assertEquals(2, result.size());
    }
}