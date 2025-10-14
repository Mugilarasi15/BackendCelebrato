package com.celebrato.backend.repository;


import com.celebrato.backend.model.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}

