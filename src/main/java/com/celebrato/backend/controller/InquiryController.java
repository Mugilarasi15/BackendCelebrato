package com.celebrato.backend.controller;


import com.celebrato.backend.model.Inquiry;
import com.celebrato.backend.service.InquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "*")  // Allow frontend access
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    // Save new inquiry
    @PostMapping
    public ResponseEntity<Inquiry> createInquiry(@RequestBody Inquiry inquiry) {
        Inquiry savedInquiry = inquiryService.saveInquiry(inquiry);
        return new ResponseEntity<>(savedInquiry, HttpStatus.CREATED);
    }

    // Get all inquiries
    @GetMapping
    public ResponseEntity<List<Inquiry>> getAllInquiries() {
        List<Inquiry> inquiries = inquiryService.getAllInquiries();
        return new ResponseEntity<>(inquiries, HttpStatus.OK);
    }

    // Get single inquiry
    @GetMapping("/{id}")
    public ResponseEntity<Inquiry> getInquiryById(@PathVariable Long id) {
        Inquiry inquiry = inquiryService.getInquiryById(id);
        if (inquiry != null) {
            return new ResponseEntity<>(inquiry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
