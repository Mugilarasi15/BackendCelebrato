package com.celebrato.backend.repository;


import com.celebrato.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom finder methods
    List<Employee> findByCategory(String category); // Find all employees by category (Permanent, Contract, etc.)
    
    Employee findByEmail(String email); // Find single employee by email
}
