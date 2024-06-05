package com.ra.ss.controller;

import com.ra.ss.model.entity.Department;
import com.ra.ss.model.entity.Employee;
import com.ra.ss.service.IDepartmentService;
import com.ra.ss.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {
    private final IDepartmentService departmentService;
    private final IEmployeeService employeeService;
    @RequestMapping
    public String index(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }
}
