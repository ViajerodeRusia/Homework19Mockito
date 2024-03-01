package com.skypro.Homework19Mockito.controller;

import com.skypro.Homework19Mockito.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddEmployee_InvalidInput() {
        assertThrows(ResponseStatusException.class, () -> {
            employeeController.addEmployee("123", "456", 1, 50000, model);
        });

        Mockito.verify(employeeService, Mockito.never()).addEmployee(Mockito.anyString(),
                Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());

        Mockito.verify(model, Mockito.never()).addAttribute(Mockito.anyString(), Mockito.any());
    }
}