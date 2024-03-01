package com.skypro.Homework19Mockito.controller;

import com.skypro.Homework19Mockito.domain.Employee;
import com.skypro.Homework19Mockito.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(@Autowired DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/employees")
    public String getAllEmployeesByDepartment(@RequestParam Integer department, Model model){
        List<Employee> employeesOfDepartment = departmentService.getAllEmployeesOfDepartment(department);
        model.addAttribute("employeesOfDepartment", employeesOfDepartment);
        model.addAttribute("department", department);
        return "department";
    }
    @GetMapping(path = "/salary/sum")
    public String getAllCostsByDepartment(@RequestParam Integer department, Model model) {
        List<Employee> employeesOfDepartment = departmentService.getAllEmployeesOfDepartment(department);
        model.addAttribute("employeesOfDepartment", employeesOfDepartment);
        model.addAttribute("department", department);

        Integer allCostsDep = departmentService.getCostsAllEmployeesDep(department);
        model.addAttribute("allCostsDep", allCostsDep != null ? allCostsDep : 0);
        return "sum";
    }
    @GetMapping(path = "/salary/max")
    public String getMaxSalaryByDepartment(@RequestParam Integer department, Model model) {
        List<Employee> employeesOfDepartment = departmentService.getAllEmployeesOfDepartment(department);
        model.addAttribute("employeesOfDepartment", employeesOfDepartment);
        model.addAttribute("department", department);

        Employee maxSalaryDep = departmentService.getEmployeeWithMaxSalaryDep(department);
        model.addAttribute("maxSalaryDep", maxSalaryDep != null ? maxSalaryDep.getSalary() : 0);
        return "max";
    }
    @GetMapping(path = "/salary/min")
    public String getMinSalaryByDepartment(@RequestParam Integer department, Model model) {
        List<Employee> employeesOfDepartment = departmentService.getAllEmployeesOfDepartment(department);
        model.addAttribute("employeesOfDepartment", employeesOfDepartment);
        model.addAttribute("department", department);

        Employee minSalaryDep = departmentService.getEmployeeWithMinSalaryDep(department);
        model.addAttribute("minSalaryDep", minSalaryDep != null ? minSalaryDep.getSalary() : 0);
        return "min";
    }
}

