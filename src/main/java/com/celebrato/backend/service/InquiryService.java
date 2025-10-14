package com.celebrato.backend.service;


import com.celebrato.backend.model.Inquiry;
import java.util.List;

public interface InquiryService {
    Inquiry saveInquiry(Inquiry inquiry);
    List<Inquiry> getAllInquiries();
    Inquiry getInquiryById(Long id);
}
