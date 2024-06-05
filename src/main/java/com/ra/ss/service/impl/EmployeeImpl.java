package com.ra.ss.service.impl;

import com.ra.ss.model.entity.Employee;
import com.ra.ss.repository.EmployeeRepository;
import com.ra.ss.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeImpl implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee,Integer id) {
        employee.setEmpId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
             employeeRepository.deleteById(id);
    }
}
