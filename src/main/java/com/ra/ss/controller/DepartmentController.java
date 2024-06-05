package com.ra.ss.controller;

import com.ra.ss.model.entity.Department;
import com.ra.ss.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final IDepartmentService departmentService;
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("department", new Department());
           return "add_department";
    }
    @PostMapping("/add")
    public String handleAdd(@ModelAttribute("department") Department department) {
        departmentService.addDepartment(department);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "edit_department";
    }
    @PostMapping("/edit/{id}")
    public String handleEdit(@PathVariable("id") Integer id,@ModelAttribute("department") Department department) {
        departmentService.updateDepartment(department,id);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        departmentService.deleteDepartment(id);
        return "redirect:/";
    }
}
