package com.ra.ss.service.impl;

import com.ra.ss.model.entity.Department;
import com.ra.ss.repository.DepartmentRepository;
import com.ra.ss.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
 @RequiredArgsConstructor
public class DepartmentImpl implements IDepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department,Integer id) {
        department.setId(id);
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.delete(getDepartmentById(id));
    }
}
