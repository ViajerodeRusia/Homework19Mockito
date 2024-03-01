package com.skypro.Homework19Mockito.controller;

import com.skypro.Homework19Mockito.domain.Employee;
import com.skypro.Homework19Mockito.service.DepartmentService;
import com.skypro.Homework19Mockito.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    final DepartmentService departmentService;


    public EmployeeController(@Autowired EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String main(Model model) {
        Employee minSalary = departmentService.getEmployeeWithMinSalary();
        Employee maxSalary = departmentService.getEmployeeWithMaxSalary();
        model.addAttribute("minSalary", minSalary != null ? minSalary.getSalary() :0);
        model.addAttribute("maxSalary", maxSalary != null ? maxSalary.getSalary() :0);

        Integer allCosts = departmentService.getCostsAllEmployees();
        model.addAttribute("allCosts", allCosts != null ? allCosts :0);
        return "main";
    }

    @PostMapping
    public String addEmployee(@RequestParam String name, @RequestParam String surname,
                              @RequestParam Integer department, @RequestParam Integer salary, Model model) {
        // Проверка входящих данных с помощью StringUtils
        if (!StringUtils.isAlpha(name) || !StringUtils.isAlpha(surname)
                || StringUtils.containsAny(name, "0123456789")
                || StringUtils.containsAny(surname, "0123456789")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Name and surname must contain only letters without spaces.");
        }
        // Форматирование имени и фамилии с большой буквы
        name = StringUtils.capitalize(name.toLowerCase());
        surname = StringUtils.capitalize(surname.toLowerCase());

        String result = employeeService.addEmployee(name, surname, department, salary);
        if(result.equals("duplicate")) {
            List<Employee> employees = employeeService.getAllEmployees();
            model.addAttribute("employees", employees);
            return "duplicate";
        }
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "main";
    }
}
