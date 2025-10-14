package com.celebrato.backend.service;


import com.celebrato.backend.model.Employee;
import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}