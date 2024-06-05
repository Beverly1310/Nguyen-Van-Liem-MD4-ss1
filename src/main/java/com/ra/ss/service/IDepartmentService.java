package com.ra.ss.service;

import com.ra.ss.model.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Integer id);
    Department addDepartment(Department department);
    Department updateDepartment(Department department,Integer id);
    void deleteDepartment(Integer id);

}
