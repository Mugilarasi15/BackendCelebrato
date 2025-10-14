package com.celebrato.backend.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inquiries")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiryId;

    private String name;
    private String phone;
    private String email;

    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime inquiryDate;

    @Column(length = 20)
    private String status = "New"; // default status

    // ---------------- Constructors ----------------

    public Inquiry() {
        this.inquiryDate = LocalDateTime.now();
    }

    public Inquiry(String name, String phone, String email, String message) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.message = message;
        this.inquiryDate = LocalDateTime.now();
        this.status = "New";
    }

    // ---------------- Getters & Setters ----------------

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDateTime inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
