package com.ra.ss.controller;

import com.ra.ss.model.entity.Department;
import com.ra.ss.model.entity.Employee;
import com.ra.ss.service.IDepartmentService;
import com.ra.ss.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final IDepartmentService departmentService;
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "add_employee";
    }
    @PostMapping("/add")
    public String handleAdd(@ModelAttribute("employee") Employee employee,@RequestParam("departmentId") Integer departmentId) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        employeeService.addEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "edit_employee";
    }
    @PostMapping("/edit/{id}")
    public String handleEdit(@PathVariable("id") Integer id,@ModelAttribute("employee") Employee employee,@RequestParam("departmentId") Integer departmentId) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        employeeService.updateEmployee(employee,id);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
