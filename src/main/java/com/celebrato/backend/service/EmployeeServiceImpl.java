package com.celebrato.backend.service;


import com.celebrato.backend.model.Employee;
import com.celebrato.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp.orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmp = getEmployeeById(id);
        if(existingEmp != null) {
            existingEmp.setName(employee.getName());
            existingEmp.setEmail(employee.getEmail());
            existingEmp.setCategory(employee.getCategory());
            existingEmp.setSalary(employee.getSalary());
            existingEmp.setDepartment(employee.getDepartment());
            existingEmp.setDesignation(employee.getDesignation());
            return employeeRepository.save(existingEmp);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
