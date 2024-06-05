package com.ra.ss.service;

import com.ra.ss.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(Integer id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee,Integer id);
    void deleteEmployee(Integer id);
}
