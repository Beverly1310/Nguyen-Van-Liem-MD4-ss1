package com.ra.ss.service;

import com.ra.ss.model.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(Integer id);
    Employee addEmployee(Employee employee, MultipartFile file);
    Employee updateEmployee(Employee employee,Integer id,MultipartFile file);
    void deleteEmployee(Integer id);
}
