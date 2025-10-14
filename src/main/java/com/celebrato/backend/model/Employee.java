package com.celebrato.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED) // for different types of employees
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Category is mandatory")
    private String category; // Example: Permanent, Contract, Shortlisted

    @NotNull(message = "Salary is mandatory")
    private Double salary;

    // Optional fields
    private String department;
    private String designation;

    // Constructors
    public Employee() {}

    public Employee(String name, String email, String category, Double salary, String department, String designation) {
        this.name = name;
        this.email = email;
        this.category = category;
        this.salary = salary;
        this.department = department;
        this.designation = designation;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
}
